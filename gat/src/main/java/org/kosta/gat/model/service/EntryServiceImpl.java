package org.kosta.gat.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.EntryDAO;
import org.kosta.gat.model.dao.MemberDAO;
import org.kosta.gat.model.dao.MileageDAO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageUseGroupVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntryServiceImpl implements EntryService {
	@Resource
	private EntryDAO entryDAO;
	@Resource
	private MileageDAO mileageDAO;
	@Resource
	private MemberDAO memberDAO;

	@Override
	@Transactional
	public void addTakeDonation(TakeDonationPostVO tdVO) {
		// 재능기부 참여
		entryDAO.addTakeDonation(tdVO);
		// 재능기부 참여에 사용한 마일리지 내역
		MileageTradeVO mtVO = new MileageTradeVO();
		mtVO.setMtVolume(tdVO.getTdMileage());
		mtVO.setMemberVO(tdVO.getMemberVO());
		mtVO.setMugVO(new MileageUseGroupVO("2", null));
		mileageDAO.tradeMileage(mtVO);
		// 재능기부 참여한 회원의 가용 마일리지 차감, 누적 마일리지
		memberDAO.updateMemberMileage(tdVO);
	}

	@Override
	@Transactional
	public void addReview(ReviewPostVO rpVO) {
		entryDAO.addReview(rpVO);
	}

	@Override
	@Transactional
	public List<TakeDonationPostVO> findCheerupMessageByDpno(int dpno) {
		return entryDAO.findCheerupMessageByDpno(dpno);
		
	}
}
