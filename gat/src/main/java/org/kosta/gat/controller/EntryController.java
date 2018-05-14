package org.kosta.gat.controller;

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
