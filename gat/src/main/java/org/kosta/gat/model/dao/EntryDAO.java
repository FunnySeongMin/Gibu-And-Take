package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;

public interface EntryDAO {

	public void addTakeDonation(TakeDonationPostVO tdVO);

	public void addReview(ReviewPostVO rpVO);

	public List<TakeDonationPostVO> findCheerupMessageByDpno(int dpno);

}
