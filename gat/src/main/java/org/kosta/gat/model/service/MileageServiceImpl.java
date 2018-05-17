package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.MileageDAO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MileageServiceImpl implements MileageService {
	@Resource
	private MileageDAO mileageDAO;

	@Override
	@Transactional
	public void addMileage(MileageTradeVO mileageTradeVO) {
		mileageDAO.addMileage(mileageTradeVO);
	}

	@Override
	@Transactional
	public void tradeMileage(int mileage) {
		mileageDAO.tradeMileage(mileage);
	}

	@Override
	public void exchangeMileage(int mileage) {
		mileageDAO.exchangeMileage(mileage);
	}

	@Override
	public MileageTradePostListVO readMyMileageTradeList(String id, int nowPage) {
		return mileageDAO.readMyMileageTradeList(id,nowPage);
	}
}
