package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.EntryDAO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntryServiceImpl implements EntryService {
	@Resource
	private EntryDAO entryDAO;

	@Override
	@Transactional
	public void addTakeDonation(TakeDonationPostVO tdVO) {
		entryDAO.addTakeDonation(tdVO);
	}

	@Override
	@Transactional
	public void addReview(ReviewPostVO rpVO) {
		entryDAO.addReview(rpVO);
	}
}
