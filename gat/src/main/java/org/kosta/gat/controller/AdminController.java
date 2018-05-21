package org.kosta.gat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.gat.model.service.AdminService;
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
	public String updateUnReceivedApplication(String apno,String command,Model model) {
		adminService.updateUnReceivedApplication(apno,command);
		if(command.equals("거절")) {
			model.addAttribute("apno", apno);
			return "admin/writeAnswer.tiles";
		}else {
			ApplicationPostVO apVO=adminService.readUnReceivedApplicationDetail(apno);
			adminService.addDonationPost(apVO);
			return "redirect:readUnReceivedApplicationList.do?nowPage=1";
		}
	}
	/**
	* 작성이유 : 승인 거절 신청서 답변 등록
	* 
	* @author 은성민
	*/
	@RequestMapping("addApplicationAnswer.do")
	public String addApplicationAnswer(ApplicationPostVO apVO,HttpServletRequest request) {
		adminService.addApplicationAnswer(apVO);
		return "redirect:readUnReceivedApplicationDetail.do?apno="+apVO.getAppNo();
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
		return "redirect:readWebQuestionDetail.do?wqno="+wqVO.getWqNo();
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
	public String readTradePoint(int nowPage) {
		TakeDonationPostListVO tdListVO=adminService.readTradePoint(nowPage);
		return null;
	}
}
