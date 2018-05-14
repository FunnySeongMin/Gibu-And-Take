package org.kosta.gat.model.service;

import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;

public interface MileageService {

	public void addMileage(int mileage);

	public void tradeMileage(int mileage);

	public void exchangeMileage(int mileage);

	public MileageTradePostListVO readMyMileageTradeList(String id, int nowPage);

}
