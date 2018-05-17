package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;
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
	public void tradeMileage(int mileage) {
		template.update("mileage.tradeMileage", mileage);
	}

	@Override
	public void exchangeMileage(int mileage) {
		template.update("mileage.exchangeMileage",mileage);
	}

	@Override
	public MileageTradePostListVO readMyMileageTradeList(String id, int nowPage) {
		MileageTradePostPagingBean mtPb=null;
		int totalMyMileageTradeCount=template.selectOne("mileage.totalMyMileageTradeCount", id);
		if(nowPage==0) {
			mtPb=new MileageTradePostPagingBean(totalMyMileageTradeCount);
		}else {
			mtPb=new MileageTradePostPagingBean(totalMyMileageTradeCount, nowPage);
		}
		mtPb.setId(id);
		List<MileageTradeVO> list=template.selectList("mileage.readMyMileageTradeList", mtPb);
		MileageTradePostListVO mtListVO=new MileageTradePostListVO(list, mtPb);
		return mtListVO;
	}
}
