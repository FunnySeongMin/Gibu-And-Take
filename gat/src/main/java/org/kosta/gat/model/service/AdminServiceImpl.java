	package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.AdminDAO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminDAO adminDAO;

	@Override
	public ApplicationPostListVO readUnReceivedApplicationList(int nowPage) {
		return adminDAO.readUnReceivedApplicationList(nowPage);
	}

	@Override
	public ApplicationPostVO readUnReceivedApplicationDetail(String apno) {
		return adminDAO.readUnReceivedApplicationDetail(apno);
	}

	@Override
	@Transactional
	public void updateUnReceivedApplication(String apno, String command) {
		adminDAO.updateUnReceivedApplication(apno,command);
	}

	@Override
	@Transactional
	public void addApplicationAnswer(ApplicationPostVO apVO) {
		adminDAO.addApplicationAnswer(apVO);
	}

	@Override
	@Transactional
	public void addDonationPost(ApplicationPostVO apVO) {
		adminDAO.addDonationPost(apVO);
	}

	@Override
	public WebQuestionPostListVO readWebQuestionList(int nowPage) {
		return adminDAO.readWebQuestionList(nowPage);
	}

	@Override
	public WebQuestionPostVO readWebQuestionDetail(String wqno) {
		return adminDAO.readWebQuestionDetail(wqno);
	}

	@Override
	@Transactional
	public void addWebQuestionAnswer(WebQuestionPostVO wqVO) {
		adminDAO.addWebQuestionAnswer(wqVO);
	}

	@Override
	@Transactional
	public void updateWebQuestionAnswer(WebQuestionPostVO wqVO) {
		adminDAO.updateWebQuestionAnswer(wqVO);
	}

	@Override
	public int appCount() {
		return adminDAO.appCount();
	}

	@Override
	public int questionCount() {
		return adminDAO.questionCount();
	}

	@Override
	public int memberCount() {
		return adminDAO.memberCount();
	}

	@Override
	public int tradePointCount() {
		return adminDAO.tradePointCount();
	}
}
