package org.kosta.gat.model.service;

import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;

public interface MemberService {

	public void registerMember(MemberVO vo);

	public MemberVO checkId(String id);

	public void updateMember(MemberVO vo);
	
	public void deleteMember(String id);
	
	public void addWebQuestion(WebQuestionPostVO webVO);

	public WebQuestionPostListVO readWebQuestion(int nowPage);

	public void updateWebQuestion(WebQuestionPostVO wqVO);

	public void deleteWebQuestion();

	public ReviewPostListVO readMyReviewPostList(String id, int nowPage);

	public TakeDonationPostListVO readMyActivityList(String id, int nowPage);
}
