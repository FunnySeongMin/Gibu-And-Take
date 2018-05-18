package org.kosta.gat.model.service;

import java.util.List;

import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;

public interface MileageService {

	public void addMileage(MileageTradeVO mileageTradeVO);
	
	public void tradeMileage(MileageTradeVO mtVO);

	public void exchangeMileage(MileageTradeVO mileageTradeVO);
/*
	public MileageTradePostListVO readMyMileageTradeList(String id, int nowPage);*/

	public List<MileageTradeVO> readMyMileageTradeList(String string);

}
