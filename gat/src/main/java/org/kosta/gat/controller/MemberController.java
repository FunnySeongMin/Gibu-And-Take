package org.kosta.gat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.gat.model.service.MemberService;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String addWebQuestion(HttpServletRequest request, WebQuestionPostVO webVO, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "member/loginForm.tiles";
		}
		//session -> MemberVO로 회원 정보 저장
		MemberVO mvo =  (MemberVO) session.getAttribute("mvo");
		webVO.setMemberVO(mvo);
		//addWebQuestion
		memberService.addWebQuestion(webVO);
		//작성한 게시글을 바로 보여 주기 위해 wqNo 부여함
		redirectAttributes.addAttribute("wqNo", +webVO.getWqNo());
		return "redirect:/member/readMyWebQuestionDetail.do";
	}
	/**
	* 작성이유 : 나의 문의 게시판 목록 보기
	* 
	* @author 용다은
	*/
	@RequestMapping("member/readMyWebQuestionList.do")
	public String readMyWebQuestionList(int nowPage, HttpServletRequest request, Model model) {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){ //session 없는 경우 로그인 페이지로 보냄
			return "member/loginForm.tiles";
		}
		MemberVO mvo=(MemberVO) session.getAttribute("mvo");
		WebQuestionPostListVO wqListVO = memberService.readMyWebQuestionList(mvo.getId(), nowPage);
		model.addAttribute("wqListVO", wqListVO);
		return "member/readMyWebQuestionList.tiles";
	}
/**
	* 작성이유 : 고객문의 게시판 게시글 상세 보기
	* 
	* @author 용다은
	*/
	@RequestMapping("member/readMyWebQuestionDetail.do")
	public String readWebQuestion(int wqNo, Model model) {
		WebQuestionPostVO wqPostVO=memberService.readMyWebQuestionDetail(wqNo);
		model.addAttribute("wqPostVO", wqPostVO);
		//답변완료 된 문의글인 경우 답변VO를 찾는 메서드
		if(wqPostVO.getWqStatus().equals("답변완료")) {
			WebQuestionPostVO wqAnswerVO = memberService.readWebQuestionAnswer(wqNo);
			//답변VO를 view로 보내줌
			model.addAttribute("wqAnswerVO", wqAnswerVO);
			}
		return "member/readMyWebQuestionDetail.tiles";
	}
	/**
	* 작성이유 : 고객문의 게시판 게시글 수정 폼으로 이동하기 위해
	* 
	* @author 용다은
	*/
	@RequestMapping("member/updateWebQuestionForm.do")
	public String updateWebQuestionForm(int wqNo, Model model) {
		WebQuestionPostVO wqPostVO=memberService.readMyWebQuestionDetail(wqNo);
		model.addAttribute("wqPostVO", wqPostVO);
		return "member/updateWebQuestionForm.tiles";
	}
	/**
	* 작성이유 : 고객문의 게시판 게시글 수정
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="member/updateWebQuestion.do")
	public String updateWebQuestion(WebQuestionPostVO wqVO, Model model) {
		//새로 작성한 wqTitle과 wqContents를 받아온 wqVO를 이용해 update 시킴
		memberService.updateWebQuestion(wqVO);
		//wqNo를 이용해 detail을 읽어들임
		WebQuestionPostVO wqPostVO=memberService.readMyWebQuestionDetail(wqVO.getWqNo());
		//가져온 wqPostVO를 뿌려줌
		model.addAttribute("wqPostVO", wqPostVO);
		return "member/readMyWebQuestionDetail.tiles";
	}
	/**
	* 작성이유 : 고객문의 게시판 게시글 삭제
	* 
	* @author 용다은
	*/
	@RequestMapping("member/deleteWebQuestion.do")
	public String deleteWebQuestion(int wqNo) {
		memberService.deleteWebQuestion(wqNo);
		return "redirect:/member/readMyWebQuestionList.do?nowPage=1";
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
		return new ModelAndView("member/myReviewList.tiles","rpListVO",rpListVO);
	}
	/**
	* 작성이유 : 나의 재능기부 참여목록 
	* 
	* @author 백설희
	*/
	@RequestMapping("member/readMyActivityList.do")
	public ModelAndView readMyActivityList(int nowPage,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		TakeDonationPostListVO tdListVO=memberService.readMyActivityList(mvo.getId(),nowPage);
		System.out.println(tdListVO);
		return new ModelAndView("member/readMyActivityList.tiles","tdListVO",tdListVO);
	}
	/**
	* 작성이유 : 나의 재능기부 신청 내역
	* 
	* @author 백설희
	*/
	@RequestMapping("member/readMyApplicationList.do")
	public ModelAndView readMyApplicationList(int nowPage,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		ApplicationPostListVO apListVO=memberService.readMyApplicationList(mvo.getId(),nowPage);
		System.out.println(apListVO);
		return new ModelAndView("member/readMyApplicationList.tiles","apListVO",apListVO);
	}
	/**
	* 작성이유 : 나의 후기 상세보기
	* 
	* @author 백설희
	*/
	@RequestMapping("member/readMyReviewDetail.do")
	public String readMyReviewDetail(String rpNo,Model model) {
		System.out.println("controller에서 rpNo 값 :"+rpNo);
		ReviewPostVO reviewPostVO=memberService.readMyReviewDetail(rpNo);
		System.out.println(reviewPostVO);
		//redirectAttributes.addAttribute("reviewPostVO", reviewPostVO);
		model.addAttribute("reviewPostVO", reviewPostVO);
		return "member/readMyReviewDetail.tiles";
	}
}
