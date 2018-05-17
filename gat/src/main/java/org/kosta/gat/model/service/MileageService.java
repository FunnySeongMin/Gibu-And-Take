package org.kosta.gat.model.service;

import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;

public interface MileageService {

	public void addMileage(MileageTradeVO mileageTradeVO);

	public void tradeMileage(int mileage);

	public void exchangeMileage(int mileage);

	public MileageTradePostListVO readMyMileageTradeList(String id, int nowPage);

}
