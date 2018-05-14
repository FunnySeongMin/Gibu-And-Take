package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.MemberDAO;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
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
	public WebQuestionPostListVO readWebQuestion(int nowPage) {
		return memberDAO.readWebQuestion(nowPage);
	}

	@Override
	@Transactional
	public void updateWebQuestion(WebQuestionPostVO wqVO) {
		memberDAO.updateWebQuestion(wqVO);
	}

	@Override
	public void deleteWebQuestion() {
		memberDAO.deleteWebQuestion();
	}

	@Override
	public ReviewPostListVO readMyReviewPostList(String id, int nowPage) {
		return memberDAO.readMyReviewPostList(id,nowPage);
	}

	@Override
	public TakeDonationPostListVO readMyActivityList(String id, int nowPage) {
		return memberDAO.readMyActivityList(id,nowPage);
	}
}
