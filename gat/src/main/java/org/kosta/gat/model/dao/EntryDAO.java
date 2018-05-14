package org.kosta.gat.model.dao;

import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;

public interface EntryDAO {

	public void addTakeDonation(TakeDonationPostVO tdVO);

	public void addReview(ReviewPostVO rpVO);

}
