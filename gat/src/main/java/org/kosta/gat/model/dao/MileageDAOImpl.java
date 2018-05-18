package org.kosta.gat.model.dao;

import java.util.List;

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
	public List<MileageTradeVO> readMyMileageTradeList(String id) {
		/*MileageTradePostPagingBean mtPb=null;
		int totalMyMileageTradeCount=template.selectOne("mileage.totalMyMileageTradeCount", id);
		if(nowPage==0) {
			mtPb=new MileageTradePostPagingBean(totalMyMileageTradeCount);
		}else {
			mtPb=new MileageTradePostPagingBean(totalMyMileageTradeCount, nowPage);
		}
		mtPb.setId(id);
		List<MileageTradeVO> list=template.selectList("mileage.readMyMileageTradeList", mtPb);
		MileageTradePostListVO mtListVO=new MileageTradePostListVO(list, mtPb);
		return mtListVO;*/
		return template.selectList("mileage.readMyMileageTradeList", id);
	}

}
