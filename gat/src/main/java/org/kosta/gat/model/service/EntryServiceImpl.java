package org.kosta.gat.model.service;

import java.util.List;

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
		System.out.println("service"+tdVO);
		entryDAO.addTakeDonation(tdVO);
	}

	@Override
	@Transactional
	public void addReview(ReviewPostVO rpVO) {
		entryDAO.addReview(rpVO);
	}

	@Override
	@Transactional
	public List<TakeDonationPostVO> findCheerupMessageByDpno(int dpno) {
		return entryDAO.findCheerupMessageByDpno(dpno);
		
	}
}
