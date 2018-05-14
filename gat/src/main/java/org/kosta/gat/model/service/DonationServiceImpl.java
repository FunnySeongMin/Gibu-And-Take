package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.DonationDAO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationServiceImpl implements DonationService {
	@Resource
	private DonationDAO donationDAO;

	@Override
	public DonationPostListVO readDonationList(int nowPage) {
		return donationDAO.readDonationList(nowPage);
	}

	@Override
	public DonationPostVO readDonationDetail(String dpno) {
		return donationDAO.readDonationDetail(dpno);
	}

	@Override
	public ReviewPostListVO readDonationReviewList(String dpno,int nowPage) {
		return donationDAO.readDonationReviewList(dpno,nowPage);
	}

	@Override
	public ReviewPostVO readReviewDetail(String rpno) {
		return donationDAO.readReviewDetail(rpno);
	}

	@Override
	@Transactional
	public void addApplication(ApplicationPostVO apVO) {
		donationDAO.addApplication(apVO);
	}

	@Override
	@Transactional
	public void updateApplication(ApplicationPostVO apVO) {
		donationDAO.updateApplication(apVO);
	}
}
