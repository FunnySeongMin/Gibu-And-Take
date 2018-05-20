package org.kosta.gat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.gat.model.service.MemberService;
import org.kosta.gat.model.service.MileageService;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageUseGroupVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MileageController {
	@Resource
	private MileageService mileageService;
	@Resource
	private MemberService memberService;
	/**
	* 마일리지 충전
	* mileage 거래량을 받아서 저장시키는 용도
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="member/addMileage.do")
	public String addMileage(String mugNo, String id, MileageTradeVO mileageTradeVO, HttpServletRequest request) {
		//session 정보를 확인
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
				return "member/loginForm.tiles";
		}
		else{ //login 상태면 mvo를 받아와서 MemberVO에 넣어줌
			MemberVO mvo=(MemberVO) session.getAttribute("mvo");
			mileageTradeVO.setMemberVO(mvo);	
		//MileageUseGroupVO에 mugNo를 넣어 거래 종류를 저장하고
		//mileageTradeVO에 넣어줌
		MileageUseGroupVO mugVO = new MileageUseGroupVO(mugNo, null);
		mileageTradeVO.setMugVO(mugVO);
		//mileageTradeVO에 정보를 저장시켜 addMileage시킴
		mileageService.addMileage(mileageTradeVO);
		//addMileage된 내용을 MemberVO의 mileage에 업데이트 시킴
		mileageTradeVO.getMemberVO().setMileage(mileageTradeVO.getMtVolume());
		memberService.addMemberMileage(mileageTradeVO);
		request.getSession().setAttribute("mvo", memberService.checkId(mileageTradeVO.getMemberVO().getId()));
		return "redirect:/member/readMyMileageTradeList.do?nowPage=1";
		}
	}
	/**
	* 작성이유 : 마일리지 거래
	* 
	* @author 용다은
	*/
	@RequestMapping("tradeMileage.do")
	public String tradeMileage(MileageTradeVO mtVO) {
		mileageService.tradeMileage(mtVO);
		return null;
	}
	/**
	* 작성이유 : 마일리지 환전
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="member/exchangeMileage.do")
	public String exchangeMileage(String mugNo, String id, MileageTradeVO mileageTradeVO, HttpServletRequest request) {
		//session 정보를 확인
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
				System.out.println("asdasdds");
				return "member/loginForm.tiles";
			}
		else{ //login 상태면 mvo를 받아와서 MemberVO에 넣어줌
			MemberVO mvo=(MemberVO) session.getAttribute("mvo");
			mileageTradeVO.setMemberVO(mvo);		
		//MileageUseGroupVO에 mugNo를 넣어 거래 종류를 저장하고
		//mileageTradeVO에 넣어줌
		MileageUseGroupVO mugVO = new MileageUseGroupVO(mugNo, null);
		mileageTradeVO.setMugVO(mugVO);
		//mileageTradeVO에 정보를 저장시켜 addMileage시킴
		mileageService.exchangeMileage(mileageTradeVO);
		//addMileage된 내용을 MemberVO의 mileage에 업데이트 시킴
		mileageTradeVO.getMemberVO().setMileage(mileageTradeVO.getMtVolume());
		memberService.exchangeMemberMileage(mileageTradeVO);
		request.getSession().setAttribute("mvo", memberService.checkId(mileageTradeVO.getMemberVO().getId()));
		return "redirect:/member/readMyMileageTradeList.do?nowPage=1";
		}
	}
	/**
	* 마일리지 사용내역
	* 
	* 작성이유 : 사용 내역을 가져와서 보여주는 메서드
	* 
	* @author 용다은
	*/
	@RequestMapping("member/readMyMileageTradeList.do")
	public ModelAndView readMyMileageTradeList(HttpServletRequest request, int nowPage) {
		//session 정보를 확인
		HttpSession session=request.getSession(false);
			if(session!=null){ //login 상태면 mvo를 받아와서 MemberVO에 넣어줌
				MemberVO mvo=(MemberVO) session.getAttribute("mvo");
				MileageTradePostListVO listVO = mileageService.readMyMileageTradeList(mvo.getId(), nowPage); 
				return new ModelAndView("member/readMyMileageTradeList.tiles","listVO", listVO);
			}
			else
				return null; //session==null 일 때 ModelAndView 어찌함?
	}
}
