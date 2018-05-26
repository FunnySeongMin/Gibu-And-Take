package org.kosta.gat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.gat.model.service.AdminService;
import org.kosta.gat.model.service.MileageService;
import org.kosta.gat.model.vo.member.MemberListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@Resource
	private AdminService adminService;
	@Resource
	private MileageService mileageService;
	
	/**
	 * 작성이유 : 관리자 페이지 뷰 데이터 전송
	 * 
	 * @author 은성민
	 */
	@RequestMapping("adminPageData.do")
	public String adminPage(Model model) {
		int appCount=adminService.appCount();
		int qCount=adminService.questionCount();
		int memberCount=adminService.memberCount();
		int tradePointCount=adminService.tradePointCount();
		model.addAttribute("appCount", appCount);
		model.addAttribute("qCount", qCount);
		model.addAttribute("memberCount", memberCount);
		model.addAttribute("tradePointCount", tradePointCount);
		return "admin/adminPage.tiles";
	}
	/**
	* 작성이유 : 신청서 목록보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readApplicationList.do")
	public String readApplicationList(int nowPage,Model model) {
		ApplicationPostListVO apListVO=adminService.readApplicationList(nowPage);
		model.addAttribute("apListVO", apListVO);
		return "admin/readApplicationList.tiles";
	}
	/**
	* 작성이유 : 신청서 상세보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readApplicationDetail.do")
	public String readApplicationDetail(String apno,Model model) {
		ApplicationPostVO apVO=adminService.readApplicationDetail(apno);
		model.addAttribute("apVO", apVO);
		return "admin/readApplicationDetail.tiles";
	}
	/**
	 * 작성이유 미승인 신청서 목록보기
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readUnReceivedApplicationList.do")
	public String readUnReceivedApplicationList(int nowPage,Model model) {
		ApplicationPostListVO apListVO=adminService.readUnReceivedApplicationList(nowPage);
		model.addAttribute("apListVO", apListVO);
		return "admin/readUnReceivedApplicationList.tiles";
	}
	/**
	 * 작성이유 : 미승인 신청서 상세보기
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readUnReceivedApplicationDetail.do")
	public String readUnReceivedApplicationDetail(String apno,Model model) {
		ApplicationPostVO apVO=adminService.readApplicationDetail(apno);
		model.addAttribute("apVO", apVO);
		return "admin/readUnReceivedApplicationDetail.tiles";
	}
	/**
	* 작성이유 : 미승인 신청서 승인여부 업데이트
	* 
	* @author 은성민
	*/
	@RequestMapping("updateUnReceivedApplication.do")
	public String updateUnReceivedApplication(String apno,String command,Model model) {
		if(command.equals("거절")) {
			model.addAttribute("apno", apno);
			return "admin/writeAnswer.tiles";
		}else {
			adminService.updateUnReceivedApplication(apno,command);
			ApplicationPostVO apVO=adminService.readApplicationDetail(apno);
			adminService.addDonationPost(apVO);
			return "redirect:readApplicationList.do?nowPage=1";
		}
	}
	/**
	* 작성이유 : 승인 거절 신청서 답변 등록
	* 
	* @author 은성민
	*/
	@RequestMapping("addApplicationAnswer.do")
	public String addApplicationAnswer(ApplicationPostVO apVO,HttpServletRequest request,String command) {
		adminService.updateUnReceivedApplication(apVO.getAppNo(), command);
		adminService.addApplicationAnswer(apVO);
		return "redirect:readApplicationDetail.do?apno="+apVO.getAppNo();
	}
	/**
	* 작성이유 : 사이트 문의 목록보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readWebQuestionList.do")
	public String readWebQuestionList(int nowPage,Model model) {
		WebQuestionPostListVO wqListVO=adminService.readWebQuestionList(nowPage);
		model.addAttribute("wqListVO", wqListVO);
		return "admin/readWebQuestionList.tiles";
	}
	/**
	 * 작성이유 : 문의중인 문의목록
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readUnReceivedWebQuestionList.do")
	public String readUnReceivedWebQuestionList(int nowPage,Model model) {
		WebQuestionPostListVO wqListVO=adminService.readUnReceivedWebQuestionList(nowPage);
		model.addAttribute("wqListVO", wqListVO);
		return "admin/readUnReceivedWebQuestionList.tiles";
	}
	/**
	* 작성이유 : 사이트 문의 상세보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readWebQuestionDetail.do")
	public String readWebQuestionDetail(String wqno,Model model) {
		WebQuestionPostVO wqVO=adminService.readWebQuestionDetail(wqno);
		model.addAttribute("wqVO", wqVO);
		return "admin/readWebQuestionDetail.tiles";
	}
	/**
	 * 작성이유 : 답변없는 문의글 상세보기
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readUnReceivedWebQuestionDetail.do")
	public String readUnReceivedWebQuestionDetail(String wqno,Model model) {
		WebQuestionPostVO wqVO=adminService.readUnReceivedWebQuestionDetail(wqno);
		model.addAttribute("wqVO", wqVO);
		return "admin/readUnReceivedWebQuestionDetail.tiles";
	}
	/**
	 * 작성이유 :  문의 답변작성 폼으로 이동
	 * 
	 * @author 은성민
	 */
	@RequestMapping("writeWebQuestionAnswer.do")
	public String writeWebQuestionAnswer(String wqno,Model model) {
		model.addAttribute("wqno", wqno);
		return "admin/writeWebQuestionAnswer.tiles";
	}
	/**
	* 작성이유 : 사이트 문의 답변작성
	* 
	* @author 은성민
	*/
	@RequestMapping("addWebQuestionAnswer.do")
	public String addWebQuestionAnswer(WebQuestionPostVO wqVO) {
		adminService.addWebQuestionAnswer(wqVO);
		return "redirect:readUnReceivedWebQuestionDetail.do?wqno="+wqVO.getWqNo();
	}
	/**
	* 작성이유 : 사이트 문의 답변수정
	* 
	* @author 은성민
	*/
	@RequestMapping("updateWebQuestionAnswer.do")
	public String updateWebQuestionAnswer(WebQuestionPostVO wqVO) {
		System.out.println(wqVO);
		adminService.updateWebQuestionAnswer(wqVO);
		return "redirect:readWebQuestionDetail?wqno="+wqVO.getWqNo();
	}
	/**
	 * 작성이유 : 전체 회원 리스트 목록보기
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readMemberList.do")
	public String readMemberList(int nowPage,Model model) {
		MemberListVO mListVO=adminService.readMemberList(nowPage);
		model.addAttribute("mListVO", mListVO);
		return "admin/readMemberList.tiles";
	}
	/**
	 * 작성이유 : 탈퇴한 회원 리스트 목록보기
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readDropMemberList.do")
	public String readDropMemberList(int nowPage,Model model) {
		MemberListVO mListVO=adminService.readDropMemberList(nowPage);
		model.addAttribute("mListVO", mListVO);
		return "admin/readDropMemberList.tiles";
	}
	/**
	 * 작성이유 : 회원 강제탈퇴
	 * 
	 * @author 은성민
	 */
	@RequestMapping("deleteMember.do")
	public String deleteMember(String id) {
		adminService.deleteMember(id);
		return "redirect:readMemberList.do?nowPage=1";
	}
	/**
	 * 작성이유 : 탈퇴한 회원 복구
	 * 
	 * @author 은성민
	 */
	@RequestMapping("restoreMember.do")
	public String restoreMember(String id) {
		adminService.restoreMember(id);
		return "redirect:readDropMemberList.do?nowPage=1";
	}
	/**
	 * 작성이유 : 포인트 지급대상 리스트
	 * 
	 * @author 은성민
	 */
	@RequestMapping("readTradePoint.do")
	public String readTradePoint(int nowPage,Model model) {
		TakeDonationPostListVO tdListVO=adminService.readTradePoint(nowPage);
		model.addAttribute("tdListVO", tdListVO);
		return "admin/readTradePointList.tiles";
	}
	/**
	 * 작성이유 : 포인트 지급
	 * 
	 * @author 은성민
	 */
	@RequestMapping("givePoint.do")
	public String givePoint(String id,int mileage,int tdNo) {
		adminService.givePoint(id,mileage,tdNo);
		//마일리지 테이블에 적립하기 위함
		mileageService.saveMileage(id, mileage);
		return "redirect:readTradePoint.do?nowPage=1";
	}
	/**
	 * 작성이유 : 답변 수정폼 으로 이동
	 * 
	 * @author 은성민
	 */
	@RequestMapping("updateWebQuestionForm.do")
	public String updateWebQuestionForm(String wqno,Model model) {
		WebQuestionPostVO wqVO=adminService.readWebQuestionDetail(wqno);
		model.addAttribute("wqVO", wqVO);
		return "admin/updateWebQuestionForm.tiles";
	}
}
