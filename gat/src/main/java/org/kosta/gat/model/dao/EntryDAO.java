package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;

public interface EntryDAO {

	public void addTakeDonation(TakeDonationPostVO tdVO);

	public void addReview(ReviewPostVO rpVO);

	public TakeDonationPostListVO findCheerupMessageByDpno(String dpno, int nowPage);

	public TakeDonationPostVO findEntryByIdAndDpno(TakeDonationPostVO tdVO);

}
