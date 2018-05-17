package org.kosta.gat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.gat.model.service.AdminService;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@Resource
	private AdminService adminService;
	
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
	* 작성이유 : 미승인 신청서 목록보기
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
		ApplicationPostVO apVO=adminService.readUnReceivedApplicationDetail(apno);
		model.addAttribute("apVO", apVO);
		return "admin/readUnReceivedApplicationDetail.tiles";
	}
	/**
	* 작성이유 : 미승인 신청서 승인여부 업데이트
	* 
	* @author 은성민
	*/
	@RequestMapping("updateUnReceivedApplication.do")
	public String updateUnReceivedApplication(String apno,String command) {
		adminService.updateUnReceivedApplication(apno,command);
		return null;
	}
	/**
	* 작성이유 : 승인 거절 신청서 답변 등록
	* 
	* @author 은성민
	*/
	@RequestMapping("addApplicationAnswer.do")
	public String addApplicationAnswer(ApplicationPostVO apVO,HttpServletRequest request) {
		MemberVO vo=(MemberVO) request.getSession().getAttribute("mvo");
		apVO.setMemberVO(vo);
		adminService.addApplicationAnswer(apVO);
		return null;
	}
	/**
	* 작성이유 : 승인된 신청서 게시글 등록
	* 
	* @author 은성민
	*/
	@RequestMapping("addDonationPost.do")
	public String addDonationPost(ApplicationPostVO apVO) {
		adminService.addDonationPost(apVO);
		return null;
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
		return null;
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
		return null;
	}
	/**
	* 작성이유 : 사이트 문의 답변작성
	* 
	* @author 은성민
	*/
	@RequestMapping("addWebQuestionAnswer.do")
	public String addWebQuestionAnswer(WebQuestionPostVO wqVO) {
		adminService.addWebQuestionAnswer(wqVO);
		return null;
	}
	/**
	* 작성이유 : 사이트 문의 답변수정
	* 
	* @author 은성민
	*/
	@RequestMapping("updateWebQuestionAnswer.do")
	public String updateWebQuestionAnswer(WebQuestionPostVO wqVO) {
		adminService.updateWebQuestionAnswer(wqVO);
		return null;
	}
}
