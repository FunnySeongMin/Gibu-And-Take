package org.kosta.gat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.gat.model.service.DonationService;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	* @author 은성민
	*/
	@RequestMapping("readDonationDetail.do")
	public String readDonationDetail(String dpno,Model model) {
		DonationPostVO dpVO=donationService.readDonationDetail(dpno);
		return null;
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
	* @author 은성민
	*/
	@RequestMapping("addApplication.do")
	public String addApplication(ApplicationPostVO apVO) {
		donationService.addApplication(apVO);
		return null;
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
