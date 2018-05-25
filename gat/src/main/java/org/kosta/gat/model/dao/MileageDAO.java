package org.kosta.gat.model.dao;

import java.util.List;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostPagingBean;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;

public interface MileageDAO {

	public void addMileage(MileageTradeVO mileageTradeVO);

	public void tradeMileage(MileageTradeVO mtVO);

	public void exchangeMileage(MileageTradeVO mileageTradeVO);

	public List<MileageTradeVO> readMyMileageTradeList(MileageTradePostPagingBean pagingBean);

	public int getTotalContentCount(String id);

	public void saveMileage(MileageTradeVO mileageTradeVO);
}
