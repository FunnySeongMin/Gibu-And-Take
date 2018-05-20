package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntryDAOImpl implements EntryDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void addTakeDonation(TakeDonationPostVO tdVO) {
		template.insert("entry.addTakeDonation", tdVO);
	}

	@Override
	public void addReview(ReviewPostVO rpVO) {
		template.insert("entry.addReview", rpVO);
	}

	@Override
	public List<TakeDonationPostVO> findCheerupMessageByDpno(String dpno) {
		return template.selectList("entry.findCheerupMessageByDpno", dpno);
	}

	@Override
	public int findEntryByIdAndDpno(TakeDonationPostVO tdVO) {
		return template.selectOne("entry.findEntryByIdAndDpno",tdVO);
	}
	
}
