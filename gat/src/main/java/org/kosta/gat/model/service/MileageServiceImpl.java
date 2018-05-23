package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.MemberDAO;
import org.kosta.gat.model.dao.MileageDAO;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostListVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradePostPagingBean;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MileageServiceImpl implements MileageService {
	@Resource
	private MileageDAO mileageDAO;
	@Resource
	private MemberDAO memberDAO;

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
	@Transactional
	public MileageTradePostListVO readMyMileageTradeList(String id, int nowPage) {
		//목록에 보여 줄 마일리지 내역 수를 가져옴
		int totalCount=mileageDAO.getTotalContentCount(id);
		//페이징빈 생성
		MileageTradePostPagingBean pagingBean=null;
		if(nowPage==0) {
			pagingBean=new MileageTradePostPagingBean(totalCount);
			pagingBean.setId(id);
		}
		else {
			pagingBean=new MileageTradePostPagingBean(totalCount, nowPage);
			pagingBean.setId(id);
		}
		return new MileageTradePostListVO(mileageDAO.readMyMileageTradeList(pagingBean),pagingBean);
	}

	@Override
	@Transactional
	public void saveMileage(String id, int mileage) {
		MileageTradeVO mileageTradeVO = new MileageTradeVO();
		MemberVO mvo = memberDAO.checkId(id);
		mileageTradeVO.setMemberVO(mvo);
		mileageTradeVO.setMtVolume(mileage);
		mileageDAO.saveMileage(mileageTradeVO);
	}
}
