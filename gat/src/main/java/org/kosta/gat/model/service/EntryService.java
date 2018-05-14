package org.kosta.gat.model.service;

import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;

public interface EntryService {

	public void addTakeDonation(TakeDonationPostVO tdVO);

	public void addReview(ReviewPostVO rpVO);

}
