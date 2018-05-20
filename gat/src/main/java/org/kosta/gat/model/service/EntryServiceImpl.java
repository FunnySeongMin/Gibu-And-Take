package org.kosta.gat.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.DonationDAO;
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
	@Resource
	private DonationDAO donationDAO;

	/**
	 * 재능기부 참여
	 * 1. 재능기부 참여
	 * 		- 재능기부 응원메시지 내용(입력안하면 default), 회원id, 재능기부 게시글 번호가 db에 저장
	 * 2. 마일리지 거래
	 * 		- 재능기부 참여 시에 회원이 사용한 
	 * 				마일리지 액수, 회원id, 거래종류 번호를 db에 저장
	 * 3. 회원
	 * 		- 재능기부 참여 시 회원이 사용한 마일리지 액수를 
	 * 				가용 마일리지는 차감, 누적 마일리지는 누적 
	 * 4. 재능기부
	 * 		- 회원이 재능기부 참여 한 후  회원이 사용한 마일리지 액수를
	 * 				모금 마일리지 누적
	 * 		- 참여자 수+1
	 * 				
	 * 			
	 */
	@Override
	@Transactional
	public void addTakeDonation(TakeDonationPostVO tdVO) {
		System.out.println("entryService : "+tdVO);
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
		// 해당 재능기부 모금 마일리지, 총 재능기부 참여자 수 update
		donationDAO.updateDonationMileageAndTotalEntry(tdVO);
	}

	@Override
	@Transactional
	public void addReview(ReviewPostVO rpVO) {
		entryDAO.addReview(rpVO);
	}

	/**
	 * 응원메시지 목록 
	 * 작성이유 : 재능기부 상세페이지에 보여질 응원메시지를 보여준다
	 * 
	 * @param dpno 재능기부 글번호 : 재능기부글에 따라 달라지므로 재능기부 글번호를 받아온다
	 * @author 조민경
	 * 
	 */
	@Override
	@Transactional
	public List<TakeDonationPostVO> findCheerupMessageByDpno(String dpno) {
		return entryDAO.findCheerupMessageByDpno(dpno);
		
	}

	// 재능기부 참여여부 확인
	@Override
	public int findEntryByIdAndDpno(TakeDonationPostVO tdVO) {
		return entryDAO.findEntryByIdAndDpno(tdVO);
	}
}
