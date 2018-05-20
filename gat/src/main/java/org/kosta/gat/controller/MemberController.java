package org.kosta.gat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kosta.gat.model.service.MemberService;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	/**
	* 회원가입 메서드
	* 
	* 작성이유: MemberVO를 받아와서 db에 저장시킨다.
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="member/registerMember.do")
	public String registerMember(MemberVO vo) {
		memberService.registerMember(vo);
		return "redirect:/home.do";
	}
	/**
	* 아이디를 중복체크 하는 메서드
	* 
	* 작성이유: 아이디를 받아와서 db에 같은 아이디가 있는지 확인하고
	* 				  결과에 따라 ajax로 사용 가능 여부를 나타냄
	* 
	* @author 용다은
	*/
	@RequestMapping("member/checkId.do")
	@ResponseBody
	public String checkId(String id) {
		MemberVO mvo = memberService.checkId(id);
		if(mvo != null) {// 아이디가 이미 존재한다면
			return "fail";
		} else // 아이디가 아직 존재하지 않는다면
			return "ok";
	}
	/**
	* 로그인 메서드
	* 
	* 작성이유 : 아이디를 기준으로 MemberVO를 뽑아오며 아이디 존재 여부를 확인하고
	* 비밀번호와 비교하여 일치여부를 파악한다.
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="member/login.do")
	public String login(MemberVO vo, HttpServletRequest request) {
		MemberVO mvo=memberService.checkId(vo.getId());
		if(mvo == null ) { //아이디가 존재하지 않는 경우
			return "member/loginFail.tiles";
		}else{
			String gnum=mvo.getMemberGroupVO().getMgroupNo();
			if(!vo.getPassword().equals(mvo.getPassword())) { //비밀번호가 일치하지 않는 경우
			return "member/loginFail.tiles";
		}else if(gnum.equals("5")) {//탈퇴회원이 로그인하는 경우
			return "member/loginFail.tiles";
		}else { //정상적으로 로그인 하는 경우	
			request.getSession().setAttribute("mvo", mvo);
			return "home.tiles";
		}
		}
	}
	/**
	* 로그아웃 메서드
	* 
	* @author 용다은
	*/
	@RequestMapping("member/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "home.tiles";
	}
	/**
	* 작성이유 : 회원수정 메서드
	* 
	* @author 백설희
	*/
	@RequestMapping(method=RequestMethod.POST, value="member/update.do")
	public String updateMember(HttpServletRequest request,MemberVO vo) {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "member/loginForm.tiles";
		}
		memberService.updateMember(vo);
		session.setAttribute("mvo", memberService.checkId(vo.getId()));
		return "member/myPage.tiles";
	}
	/**
	* 작성이유 : 비밀번호 변경
	* 
	* @author 백설희
	*/
	@RequestMapping(method=RequestMethod.POST, value="member/modifyPassword.do")
	public String updatePassword(String nowPassword,HttpServletRequest request,String newPassword) {
		HttpSession session = request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "member/loginForm.tiles";
		}
		MemberVO mvo=(MemberVO) session.getAttribute("mvo");
		mvo.setPassword(newPassword);
		memberService.updatePassword(mvo);
		if (session != null)
			session.invalidate();
		return "member/loginForm.tiles";
	}
	
	/**
	* 작성이유 : 회원탈퇴 메서드
	* 
	* @author 백설희
	*/
	@RequestMapping("member/deleteMember.do")
	public String deleteMember(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "member/loginForm.tiles";
		}
		MemberVO mvo =  (MemberVO) session.getAttribute("mvo");
		memberService.deleteMember(mvo.getId());
		if (session != null)
			session.invalidate();
		return "home.tiles";
	}
	/**
	* 작성이유 : 고객문의 게시판 게시글 작성
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="board/addWebQuestion.do")
	public String addWebQuestion(HttpServletRequest request, WebQuestionPostVO webVO) {
		HttpSession session = request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "member/loginForm.tiles";
		}
		//session -> MemberVO로 회원 정보 저장
		MemberVO mvo =  (MemberVO) session.getAttribute("mvo");
		webVO.setMemberVO(mvo);
		//addWebQuestion
		memberService.addWebQuestion(webVO);
		return "redirect:/home.do"; //테스트를 위해 일단 홈으로 보냅니다
	}
	/**
	* 작성이유 : 고객문의 게시판 게시글 보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readWebQuestion.do")
	public String readWebQuestion(int nowPage,Model model) {
		WebQuestionPostListVO wqListVO=memberService.readWebQuestion(nowPage);
		return null;
	}
	/**
	* 작성이유 : 고객문의 게시판 게시글 수정
	* 
	* @author 은성민
	*/
	@RequestMapping("updateWebQuestion.do")
	public String updateWebQuestion(WebQuestionPostVO wqVO) {
		memberService.updateWebQuestion(wqVO);
		return null;
	}
	/**
	* 작성이유 : 고객문의 게시판 게시글 삭제
	* 
	* @author 은성민
	*/
	@RequestMapping("deleteWebQuestion.do")
	public String deleteWebQuestion() {
		memberService.deleteWebQuestion();
		return null;
	}
	/**
	* 작성이유 : 나의 후기목록 보기
	* 
	* @author 백설희
	*/
	@RequestMapping("member/readMyReviewPostList.do")
	public ModelAndView readMyReviewPostList(HttpServletRequest request,int nowPage) {
		HttpSession session = request.getSession(false);
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		ReviewPostListVO rpListVO=memberService.readMyReviewPostList(mvo.getId(),nowPage);
		System.out.println(rpListVO);
		return new ModelAndView("member/myReviewList.tiles","rpListVO",rpListVO);
	}
	/**
	* 작성이유 : 나의 활동목록 보기
	* 
	* @author 백설희
	*/
	@RequestMapping("readMyActivityList.do")
	public String readMyActivityList(String id,int nowPage,Model model) {
		TakeDonationPostListVO tdListVO=memberService.readMyActivityList(id,nowPage);
		return null;
	}
}
