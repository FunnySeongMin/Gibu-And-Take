package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.MemberDAO;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostPagingBean;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;

	@Override
	@Transactional
	public void registerMember(MemberVO vo) {
		memberDAO.registerMember(vo);
	}

	@Override
	@Transactional
	public MemberVO checkId(String id) {
		return memberDAO.checkId(id);
	}
	
	@Override
	@Transactional
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}
	
	@Override
	public void deleteMember(String id) {
		memberDAO.deleteMember(id);
	}

	@Override
	@Transactional
	public void addWebQuestion(WebQuestionPostVO webVO) {
		memberDAO.addWebQuestion(webVO);
	}

	@Override
	@Transactional
	public void updateWebQuestion(WebQuestionPostVO wqVO) {
		memberDAO.updateWebQuestion(wqVO);
	}

	@Override
	@Transactional
	public void deleteWebQuestion(int wqNo) {
		memberDAO.deleteWebQuestion(wqNo);
	}

	@Override
	public ReviewPostListVO readMyReviewPostList(String id, int nowPage) {
		return memberDAO.readMyReviewPostList(id,nowPage);
	}

	@Override
	public TakeDonationPostListVO readMyActivityList(String id, int nowPage) {
		return memberDAO.readMyActivityList(id,nowPage);
	}

	@Override
	public void updatePassword(MemberVO vo) {
		memberDAO.updatePassword(vo);
	}
	
	@Override
	@Transactional
	public void addMemberMileage(MileageTradeVO mileageTradeVO) {
		memberDAO.addMemberMileage(mileageTradeVO);
	}

	@Override
	@Transactional
	public void exchangeMemberMileage(MileageTradeVO mileageTradeVO) {
		memberDAO.exchangeMileage(mileageTradeVO);
	}
	
	@Override
	@Transactional
	public WebQuestionPostListVO readMyWebQuestionList(String id, int nowPage) {
		//목록에 보여 줄 문의 내역 수를 가져옴
				int totalCount= memberDAO.getTotalQuestionContentCount(id);
				//페이징빈 생성
				WebQuestionPostPagingBean pagingBean=null;
				if(nowPage==0) {
					pagingBean=new WebQuestionPostPagingBean(totalCount);
					pagingBean.setId(id);
				}
				else {
					pagingBean=new WebQuestionPostPagingBean(totalCount, nowPage);
					pagingBean.setId(id);
				}
				return new WebQuestionPostListVO(memberDAO.readMyWebQuestionList(pagingBean),pagingBean);
			}

	@Override
	@Transactional
	public WebQuestionPostVO readMyWebQuestionDetail(int wqNo) {
		return memberDAO.readMyWebQuestionDetail(wqNo);
	}
	/**
	 * 참여후기 상세보기 
	 */
	@Override
	public ReviewPostVO readMyReviewDetail(String rpNo) {
		return memberDAO.readMyReviewDetail(rpNo);
	}

	@Override
	public ApplicationPostListVO readMyApplicationList(String id, int nowPage) {
		return memberDAO.readMyApplicationList(id,nowPage);
	}

	@Override
	@Transactional
	public WebQuestionPostVO readWebQuestionAnswer(int wqNo) {
		return memberDAO.readWebQuestionAnswer(wqNo);
	}

	@Override
	public int appCount(String id) {
		return memberDAO.appCount(id);
	}

}
