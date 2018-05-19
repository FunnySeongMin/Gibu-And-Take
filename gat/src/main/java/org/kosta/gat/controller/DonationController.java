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
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.application.PresentVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostPagingBean;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DonationController {
	@Resource
	private DonationService donationService;
	
	/**
	* 작성이유 : 재능기부 목록보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readDonationList.do")
	public String readDonationList(int nowPage,Model model) {
		DonationPostListVO dpListVO=donationService.readDonationList(nowPage);
		return null;
	}
	/**
	* 작성이유 : 재능기부 상세보기
	* 
	* @author 조민경
	*/
	@RequestMapping("donation/readDonationDetail.do")
	public String readDonationDetail(String dpno, Model model) {
		DonationPostVO dpVO=donationService.readDonationDetail(dpno);
		System.out.println(dpVO);
		model.addAttribute("dpVO", dpVO);
		return "donation/readDonationDetail.tiles";
	}
	/**
	* 작성이유 : 해당 재능기부 후기게시판 보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readDonationReviewList.do")
	public String readDonationReviewList(String dpno,int nowPage,Model model) {
		ReviewPostListVO rpListVO=donationService.readDonationReviewList(dpno,nowPage);
		return null;
	}
	/**
	* 작성이유 : 해당 재능기부 후기게시판 상세보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readReviewDetail.do")
	public String readReviewDetail(String rpno,Model model) {
		ReviewPostVO rpVO=donationService.readReviewDetail(rpno);
		return null;
	}
	/**
	* 작성이유 : 재능기부 신청서 작성
	* 
	* @author 정진표
	*/
	@RequestMapping("/board/addApplication.do")
	public String addApplication(@RequestParam("main_image") MultipartFile uploadfile, ModelMap modelMap, ApplicationPostVO apVO, HttpServletRequest request, Model model) {
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
		String appNO = donationService.addApplication(apVO);
		
		ArrayList<PresentVO> list = new ArrayList<>();
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage1")), request.getParameter("presentContents1"),appNO));
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage2")), request.getParameter("presentContents2"),appNO));
		list.add(new PresentVO(null, Integer.parseInt(request.getParameter("donationMileage3")), request.getParameter("presentContents3"),appNO));
		System.out.println("apVO : "+apVO);
		//System.out.println("리스크 : "+list);
		donationService.addPresent(list);
		//model.addAttribute("test",request.getParameter("editor") );
		return "home.tiles";
	}
	
	//단일파일업로드
	@RequestMapping("photoUpload.do")
	public void photoUpload(HttpServletRequest request, PhotoVo vo){
		donationService.photoUpload(request, vo);
	}
	//다중파일업로드
	@RequestMapping("multiplePhotoUpload.do")
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response){
		donationService.multiplePhotoUpload(request, response);
		
	}
	
	@RequestMapping("file_upload_form.do")
    public String file_upload_form(ModelMap modelMap) {
        return "file_upload_form";
    }
	
	
	@RequestMapping("DonationListView.do")
	public List<Map<String,Object>> DonationListView(DonationPostPagingBean dpPb) {
		List<Map<String,Object>> list = donationService.DonationListView(dpPb);
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
