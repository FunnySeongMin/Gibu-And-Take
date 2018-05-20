package org.kosta.gat.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.gat.model.service.DonationService;
import org.kosta.gat.model.service.EntryService;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntryController {
	@Resource
	private EntryService entryService;
	@Resource
	private DonationService donationService;

	/**
	 * 재능기부 참여하기
	 * 작성이유 : 등록된 재능기부에 참여하기 위한 메소드
	 * 
	 * @author 조민경
	 */
	@RequestMapping(value="addTakeDonation.do", method=RequestMethod.POST)
	public String addTakeDonation(String dpno, TakeDonationPostVO tdVO, HttpServletRequest request) {
		// getSession(false) : 있으면 기존 세션, 없으면 null
		HttpSession session = request.getSession(false);
		MemberVO mvo = null;
		if(session!=null) {
			mvo = (MemberVO)session.getAttribute("mvo");
			if(mvo!=null) {
				// 참여하는 회원VO set
				tdVO.setMemberVO(mvo);
			}
		}
		// 재능기부 글 VO 정보 가져오기
		DonationPostVO dpVO = donationService.readDonationDetail(dpno);
		// 회원이 참여하려는 재능기부VO SET
		tdVO.setDonationPostVO(dpVO);
		entryService.addTakeDonation(tdVO);
		return "redirect:home.tiles";
	}

	/**
	 * 응원메시지 목록 
	 * 작성이유 : 재능기부 상세페이지에 보여질 응원메시지를 보여준다
	 * 
	 * @param dpno 재능기부 글번호 : 재능기부글에 따라 달라지므로 재능기부 글번호를 받아온다
	 * @author 조민경
	 * 
	 */
	@RequestMapping("findCheerupMessageByDpno.do")
	public String findCheerupMessageByDpno(int dpno) {
		List<TakeDonationPostVO> list = entryService.findCheerupMessageByDpno(dpno);
		return null;
	}

	/**
	 * 작성이유 : 참여활동 후기 작성
	 * 
	 * @author 은성민
	 */
	@RequestMapping("addReview.do")
	public String addReview(ReviewPostVO rpVO) {
		entryService.addReview(rpVO);
		return null;
	}
}
