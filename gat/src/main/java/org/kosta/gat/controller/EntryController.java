package org.kosta.gat.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.gat.model.service.EntryService;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntryController {
	@Resource
	private EntryService entryService;
	
	/**
	* 작성이유 : 참여활동 신청
	* 
	* @author 은성민
	*/
	@RequestMapping("addTakeDonation.do")
	public String addTakeDonation(TakeDonationPostVO tdVO) {
		entryService.addTakeDonation(tdVO);
		return null;
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
