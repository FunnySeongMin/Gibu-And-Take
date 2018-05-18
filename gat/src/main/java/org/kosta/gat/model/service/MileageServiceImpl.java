package org.kosta.gat.model.service;

import java.util.List;

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
	public void tradeMileage(MileageTradeVO mtVO) {
		mileageDAO.tradeMileage(mtVO);
	}

	@Override
	public void exchangeMileage(MileageTradeVO mileageTradeVO) {
		mileageDAO.exchangeMileage(mileageTradeVO);
	}

	@Override
	public List<MileageTradeVO> readMyMileageTradeList(String id) {
		return mileageDAO.readMyMileageTradeList(id);
	}
}
