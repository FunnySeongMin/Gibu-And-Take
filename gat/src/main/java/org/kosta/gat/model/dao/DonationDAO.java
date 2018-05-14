package org.kosta.gat.model.dao;

import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;

public interface DonationDAO {

	public DonationPostListVO readDonationList(int nowPage);

	public DonationPostVO readDonationDetail(String dpno);

	public ReviewPostListVO readDonationReviewList(String dpno,int nowPage);

	public ReviewPostVO readReviewDetail(String rpno);

	public void addApplication(ApplicationPostVO apVO);

	public void updateApplication(ApplicationPostVO apVO);

}
