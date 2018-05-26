package org.kosta.gat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.gat.model.dao.PhotoVo;
import org.kosta.gat.model.service.DonationService;
import org.kosta.gat.model.service.EntryService;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.application.PresentVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostPagingBean;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DonationController {
	@Resource
	private DonationService donationService;
	@Resource
	private EntryService entryService;

	/**
	 * 작성이유 : 재능기부 목록보기
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readDonationList.do")
	public String readDonationList(int nowPage, Model model) {
		DonationPostListVO dpListVO = donationService.readDonationList(nowPage);
		return null;
	}

	/**
	 * 재능기부 상세보기
	 * 작성이유 : 승인된 재능기부에 대한 정보를 상세히 볼 수 있다.
	 * 		 : 해당 재능기부에 참여한 참여자들이 기부한 마일리지 액수와 응원메시지를 볼수 있다.
	 * 
	 * @author 조민경
	 */
	@RequestMapping("donation/readDonationDetail.do")
	public String readDonationDetail(String dpno, int tdNowPage, int rpNowPage, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);		
		MemberVO mvo = null;
		TakeDonationPostVO tdpVO = new TakeDonationPostVO();
		if(session!=null&&session.getAttribute("mvo")!=null) {
			mvo = (MemberVO)session.getAttribute("mvo");
			if (mvo != null) {
				// 참여하는 회원VO set
				tdpVO.setMemberVO(mvo);
			}
			tdpVO.setDonationPostVO(donationService.readDonationDetail(dpno));
			tdpVO = entryService.findEntryByIdAndDpno(tdpVO);
		}
		// 재능기부 상세내용
		DonationPostVO dpVO = donationService.readDonationDetail(dpno);		
		// 해당 재능기부에 대한 응원메시지 목록
		TakeDonationPostListVO tdList = entryService.findCheerupMessageByDpno(dpno, tdNowPage);
		// 해당 재능기부에 대한 후기 목록
		ReviewPostListVO rpList = donationService.readDonationReviewList(dpno, rpNowPage);
		
		
		//TakeDonationPostVO tdpVO = entryService.findEntryByIdAndDpno(tdpVO)
		//List<TakeDonationPostVO> tdpList= entryService.findEntryByIdAndDpno(tdpVO);
		//System.out.println("DonationController readDonation [tdpList]"+tdpList);
		
		//해당 재능기부에 대한 선물 목록
		List<PresentVO> pList = donationService.findPresentByDpno(dpno);
		
		// 해당 재능기부에 대한 응원메시지
		model.addAttribute("tdList", tdList);
		// 해당 재능기부에 대한 후기
		model.addAttribute("rpList", rpList);
		// 해당 재능기부에 대한 상세 내용
		model.addAttribute("dpVO", dpVO);
		// 참여 여부 확인
		model.addAttribute("tdpVO", tdpVO);
		//model.addAttribute("tdpList", tdpList);
		
		//entryService.findEntryByIdAndDpno(tdpVO);
		
		model.addAttribute("pList", pList);
		
		System.out.println("DonationController [pList] : "+pList);
		
		return "donation/readDonationDetail.tiles";
	}

	/**
	 * 해당 재능기부 후기 목록 작성이유 : 해당 재능기부에 참여한 참여자들이 작성한 후기 목록을 본다.
	 * 
	 * @author 조민경
	 */
	/*
	 * @ModelAttribute("readDonationReviewList") public String
	 * readDonationReviewList(String dpno, int nowPage, Model model) {
	 * System.out.println(dpno); ReviewPostListVO rpListVO =
	 * donationService.readDonationReviewList(dpno, nowPage); return null; }
	 */

	/**
	 * 작성이유 : 해당 재능기부 후기게시판 상세보기
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readReviewDetail.do")
	public String readReviewDetail(String rpno, Model model) {
		ReviewPostVO rpVO = donationService.readReviewDetail(rpno);
		return null;
	}

	/**
	 * 작성이유 : 재능기부 신청서 작성
	 * 
	 * @author 정진표
	 */
	@RequestMapping("/board/addApplication.do")
	public String addApplication(@RequestParam("main_image") MultipartFile uploadfile, ModelMap modelMap,
			ApplicationPostVO apVO, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberVO mvo = (MemberVO) session.getAttribute("mvo");
			if (mvo != null) {
				apVO.setMemberVO(mvo);
			}
		}
		if (!uploadfile.getOriginalFilename().equals("")) {
			System.out.println("대표 이미지 파일 업로드");
			apVO.setImgDirectory(uploadfile.getOriginalFilename());

			System.out.println("대표이미지 이름 : " + apVO.getImgDirectory());
			apVO.setImgDirectory(donationService.file_upload_save(uploadfile, modelMap));
		}
		String appNO = donationService.addApplication(apVO);
		ArrayList<PresentVO> list = new ArrayList<>();
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage1")),
				request.getParameter("presentContents1"), appNO));
		if(!request.getParameter("donationMileage2").equals("")) {
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage2")),
				request.getParameter("presentContents2"), appNO));
		}
		if(!request.getParameter("donationMileage3").equals("")) {
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage3")),
				request.getParameter("presentContents3"), appNO));
		}
		System.out.println("list : "+ list);
		System.out.println("apVO : " + apVO);
		// System.out.println("리스크 : "+list);
		donationService.addPresent(list);
		// model.addAttribute("test",request.getParameter("editor") );
		return "home.tiles";
	}
	//수정게시판 로드
	@RequestMapping("/donation/modifyApplyDonationView.do")
	public String modifyApplyDonationView(String apno, HttpServletRequest request, Model model) {
		System.out.println("수정폼 로드");
		ApplicationPostVO apVO = donationService.modifyApplyDonationView(apno);
		model.addAttribute("apVO",apVO);
		return "donation/modifyApplyDonation.tiles";
	}
	//수정게시판 업데이트
	@RequestMapping("/donation/modifyApplyDonation.do")
	public String modifyApplyDonation(@RequestParam("main_image") MultipartFile uploadfile, ModelMap modelMap, ApplicationPostVO apVO, HttpServletRequest request, Model model) {
		System.out.println("수정폼 업데이트");
		HttpSession session=request.getSession(false);
		if(session!=null){
			MemberVO mvo=(MemberVO) session.getAttribute("mvo");
			if(mvo!=null){
				apVO.setMemberVO(mvo);
			}
		}		
		if(!uploadfile.getOriginalFilename().equals("")) {
    		System.out.println("대표 이미지 파일 업로드");
    		apVO.setImgDirectory(uploadfile.getOriginalFilename());
    		
    		System.out.println("대표이미지 이름 : "+apVO.getImgDirectory());
    		apVO.setImgDirectory(donationService.file_upload_save(uploadfile, modelMap)); 
    	}
		String appNO = donationService.modifyApplyDonation(apVO);

		ArrayList<PresentVO> list = new ArrayList<>();
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage1")), request.getParameter("presentContents1"),appNO));
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage2")), request.getParameter("presentContents2"),appNO));
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage3")), request.getParameter("presentContents3"),appNO));
		System.out.println("apVO : "+apVO);
		//System.out.println("리스크 : "+list);
		donationService.addPresent(list);
		// model.addAttribute("test",request.getParameter("editor") );
		return "home.tiles";
	}
	
	//단일파일업로드
	@RequestMapping("photoUpload.do")
	public void photoUpload(HttpServletRequest request, PhotoVo vo) {
		donationService.photoUpload(request, vo);
	}

	// 다중파일업로드
	@RequestMapping("multiplePhotoUpload.do")
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		donationService.multiplePhotoUpload(request, response);
	}

	@RequestMapping("file_upload_form.do")
	public String file_upload_form(ModelMap modelMap) {
		return "file_upload_form";
	}

	@RequestMapping("DonationListView.do")
	public List<Map<String, Object>> DonationListView(DonationPostPagingBean dpPb) {
		List<Map<String, Object>> list = donationService.DonationListView(dpPb);
		return list;
	}

	@RequestMapping("/donation/listDonation.do")
	public String listDonation(Model model) {
		List<Map<String, Object>> list = donationService.DonationListView2();
		List<Map<String, Object>> rank = donationService.DonationListRank();

		model.addAttribute("list", list);
		model.addAttribute("rank", rank);
		System.out.println("리스트 뷰 : " + list);
		return "donation/listDonation.tiles";
	}

	@RequestMapping("/donation/DonationListView2.do")
	@ResponseBody
	public List<Map<String, Object>> DonationListView2() {
		System.out.println("여기 오냐?");
		List<Map<String, Object>> list = donationService.DonationListView2();
		System.out.println(list);
		return list;
	}

	/**
	 * 작성이유 : 재능기부 신청서 수정
	 * 
	 * @author 은성민
	 */
	@RequestMapping("updateApplication.do")
	public String updateApplication(ApplicationPostVO apVO) {
		donationService.updateApplication(apVO);
		return null;
	}
}
