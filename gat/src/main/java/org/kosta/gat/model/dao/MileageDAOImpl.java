package org.kosta.gat.model.dao;

import java.util.List;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostPagingBean;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MileageDAOImpl implements MileageDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void addMileage(MileageTradeVO mileageTradeVO) {
		template.insert("mileage.addMileage", mileageTradeVO);
	}

	@Override
	public void tradeMileage(MileageTradeVO mtVO) {
		template.insert("mileage.tradeMileage", mtVO);
	}

	@Override
	public void exchangeMileage(MileageTradeVO mileageTradeVO) {
		template.update("mileage.exchangeMileage", mileageTradeVO);
	}

	@Override
	public List<MileageTradeVO> readMyMileageTradeList(MileageTradePostPagingBean pagingBean) {
		return template.selectList("mileage.readMyMileageTradeList", pagingBean);
	}

	@Override
	public int getTotalContentCount(String id) {
		return template.selectOne("mileage.getTotalContentCount", id);
	}

}
