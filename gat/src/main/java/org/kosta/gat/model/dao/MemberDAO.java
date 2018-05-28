package org.kosta.gat.model.dao;

import java.util.List;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.mileagetrade.MileageTradeVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostPagingBean;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;

public interface MemberDAO {

	public void registerMember(MemberVO vo);

	public MemberVO checkId(String id);

	public void updateMember(MemberVO vo);
	
	public void updatePassword(MemberVO vo);
	
	public void deleteMember(String id);
	
	public void addWebQuestion(WebQuestionPostVO webVO);


	public void updateWebQuestion(WebQuestionPostVO wqVO);

	public void deleteWebQuestion(int wqNo);

	public ReviewPostListVO readMyReviewPostList(String id, int nowPage);

	public TakeDonationPostListVO readMyActivityList(String id, int nowPage);

	public void addMemberMileage(MileageTradeVO mileageTradeVO);

	public void exchangeMileage(MileageTradeVO mileageTradeVO);
	
	public void updateMemberMileage(TakeDonationPostVO tdVO);

	public ReviewPostVO readMyReviewDetail(String rpNo);

	public ApplicationPostListVO readMyApplicationList(String id, int nowPage);

	public List<WebQuestionPostVO> readMyWebQuestionList(WebQuestionPostPagingBean pagingBean);

	public int getTotalQuestionContentCount(String id);

	public WebQuestionPostVO readMyWebQuestionDetail(int wqNo);

	public WebQuestionPostVO readWebQuestionAnswer(int wqNo);

	public int appCount(String id);

	void updateMyReview(ReviewPostVO rpVO);
	
}
