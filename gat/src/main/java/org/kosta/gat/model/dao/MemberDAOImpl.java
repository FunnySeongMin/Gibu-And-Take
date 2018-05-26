package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostPagingBean;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostPagingBean;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostPagingBean;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostPagingBean;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void registerMember(MemberVO vo) {
		template.insert("member.registerMember", vo);
	}

	@Override
	public MemberVO checkId(String id) {
		return template.selectOne("member.checkId", id);
	}

	@Override
	public void updateMember(MemberVO vo) {
		template.update("member.updateMember", vo);
	}
	@Override
	public void updatePassword(MemberVO vo) {
		template.update("member.updatePassword", vo);
	}
	
	@Override
	public void deleteMember(String id) {
		template.delete("member.deleteMember", id);
	}
	
	@Override
	public void addWebQuestion(WebQuestionPostVO webVO) {
		template.insert("member.addWebQuestion", webVO);
	}

	@Override
	public List<WebQuestionPostVO> readMyWebQuestionList(WebQuestionPostPagingBean pagingBean) {
		return template.selectList("member.readMyWebQuestionList", pagingBean);
	}

	@Override
	public void updateWebQuestion(WebQuestionPostVO wqVO) {
		template.update("member.updateWebQuestion", wqVO);
	}

	@Override
	public void deleteWebQuestion(int wqNo) {
		template.delete("member.deleteWebQuestion", wqNo);
	}

	@Override
	public ReviewPostListVO readMyReviewPostList(String id, int nowPage) {
		ReviewPostPagingBean rpPb=null;
		//나의 후기글 목록의 수를 가져온다.
		int totalMyReviewPostCount=template.selectOne("member.totalMyReviewPostCount",id);
		if(nowPage==0) {
			rpPb=new ReviewPostPagingBean(totalMyReviewPostCount);
		}else {
			rpPb=new ReviewPostPagingBean(totalMyReviewPostCount, nowPage);
		}
		rpPb.setId(id);
		List<ReviewPostVO> rpList=template.selectList("member.readMyReviewPostList", rpPb);
		ReviewPostListVO rpListVO=new ReviewPostListVO(rpList, rpPb);
		return rpListVO;
	}

	@Override
	public TakeDonationPostListVO readMyActivityList(String id, int nowPage) {
		TakeDonationPostPagingBean tdPb=null;
		//나의 활동 총 숫자를 가져온다.
		int totalMyActivityCount=template.selectOne("member.totalMyActivityCount", id);
		if(nowPage==0) {
			tdPb=new TakeDonationPostPagingBean(totalMyActivityCount);
		}else {
			tdPb=new TakeDonationPostPagingBean(totalMyActivityCount, nowPage);
		}
		tdPb.setId(id);
		List<TakeDonationPostVO> tdList=template.selectList("member.readMyActivityList",tdPb);
		TakeDonationPostListVO tdListVO=new TakeDonationPostListVO(tdList, tdPb);
		return tdListVO;
	}

	@Override
	public void addMemberMileage(MileageTradeVO mileageTradeVO) {
		template.update("member.addMemberMileage", mileageTradeVO);
	}

	@Override
	public void exchangeMileage(MileageTradeVO mileageTradeVO) {
		template.update("member.exchangeMemberMileage", mileageTradeVO);
	}
	
	/**
	 * '참여하기' 기능 구현 시,
	 * 가용 마일리지를 사용한 마일리지를 차감하고
	 * 누적 마일리지에 사용한 마일리지를 누적한다.
	 */
	@Override
	public void updateMemberMileage(TakeDonationPostVO tdVO) {
		template.update("member.updateMemberMileage",tdVO);
		
	}
	@Override
	public int getTotalQuestionContentCount(String id) {
		return template.selectOne("member.getTotalQuestionContentCount", id);
	}

	@Override
	public WebQuestionPostVO readMyWebQuestionDetail(int wqNo) {
		return template.selectOne("member.readMyWebQuestionDetail", wqNo);
	}
	
	/**
	 * '나의 후기 목록'에서 
	 * 해당 게시물을 클릭한 상세보기
	 * 
	 */
	@Override
	public ReviewPostVO readMyReviewDetail(String rpNo) {
		ReviewPostVO reviewPostVO=template.selectOne("member.readMyReviewDetail", rpNo);
		return reviewPostVO;
	}
	/**
	 * 나의 재능기부 신청 내역
	 */
	@Override
	public ApplicationPostListVO readMyApplicationList(String id, int nowPage) {
		ApplicationPostPagingBean apPb=null;
		//나의 후기글 목록의 수를 가져온다.
		int totalMyApplicationPostCount=template.selectOne("member.totalMyApplicationPostCount",id);
		if(nowPage==0) {
			apPb=new ApplicationPostPagingBean(totalMyApplicationPostCount);
		}else {
			apPb=new ApplicationPostPagingBean(totalMyApplicationPostCount, nowPage);
		}
		apPb.setId(id);
		List<ApplicationPostVO> apList=template.selectList("member.readMyApplicationPostList", apPb);
		ApplicationPostListVO apListVO=new ApplicationPostListVO(apList, apPb);
		return apListVO;
	}

	@Override
	public WebQuestionPostVO readWebQuestionAnswer(int wqNo) {
		return template.selectOne("member.readWebQuestionAnswer", wqNo);
	}

	@Override
	public int appCount(String id) {
		return template.selectOne("member.totalMyActivityCount",id);
	}

	@Override
	public void deleteMyReview(String rpNo) {
		template.delete("member.deleteMyReview", rpNo);
	}
}
