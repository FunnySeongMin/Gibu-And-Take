package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.member.MemberListVO;
import org.kosta.gat.model.vo.member.MemberPagingBean;
import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostPagingBean;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostPagingBean;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public ApplicationPostListVO readUnReceivedApplicationList(int nowPage) {
		ApplicationPostPagingBean apPb=null;
		int totalUnReceivedApplicationCount=template.selectOne("admin.totalUnReceivedApplicationCount");
		if(nowPage==0) {
			apPb=new ApplicationPostPagingBean(totalUnReceivedApplicationCount);
		}else {
			apPb=new ApplicationPostPagingBean(totalUnReceivedApplicationCount, nowPage);
		}
		List<ApplicationPostVO> list=template.selectList("admin.readUnReceivedApplicationList",apPb);
		ApplicationPostListVO apListVO=new ApplicationPostListVO(list, apPb);
		return apListVO;
	}

	@Override
	public ApplicationPostVO readUnReceivedApplicationDetail(String apno) {
		return template.selectOne("admin.readUnReceivedApplicationDetail", apno);
	}

	@Override
	@Transactional
	public void updateUnReceivedApplication(String apno, String command) {
		if(command.equals("거절")) {
			template.update("admin.rejectionApplication", apno);
		}else {
			template.update("admin.approvalApplication",apno);
		}
	}

	@Override
	@Transactional
	public void addApplicationAnswer(ApplicationPostVO apVO) {
		template.insert("admin.addApplicationAnswer", apVO);
	}

	@Override
	@Transactional
	public void addDonationPost(ApplicationPostVO apVO) {
		template.insert("admin.addDonationPost", apVO);
	}

	@Override
	public WebQuestionPostListVO readWebQuestionList(int nowPage) {
		WebQuestionPostPagingBean wqPb=null;
		int totalWebQuestionCount=template.selectOne("admin.totalWebQuestionCount");
		if(nowPage==0) {
			wqPb=new WebQuestionPostPagingBean(totalWebQuestionCount);
		}else {
			wqPb=new WebQuestionPostPagingBean(totalWebQuestionCount, nowPage);
		}
		List<WebQuestionPostVO> wqList=template.selectList("admin.readWebQuestionList",wqPb);
		WebQuestionPostListVO wqListVO=new WebQuestionPostListVO(wqList, wqPb);
		return wqListVO;
	}

	@Override
	public WebQuestionPostVO readWebQuestionDetail(String wqno) {
		return template.selectOne("admin.readWebQuestionDetail", wqno); 
	}

	@Override
	public void addWebQuestionAnswer(WebQuestionPostVO wqVO) {
		template.update("admin.updateWebQuestionStatus",wqVO);
		template.insert("admin.addWebQuestionAnswer", wqVO);
	}

	@Override
	public void updateWebQuestionAnswer(WebQuestionPostVO wqVO) {
		template.update("admin.updateWebQuestionAnswer",wqVO);
	}

	@Override
	public int appCount() {
		return template.selectOne("admin.totalUnReceivedApplicationCount");
	}

	@Override
	public int questionCount() {
		return template.selectOne("admin.questionCount");
	}

	@Override
	public int memberCount() {
		return template.selectOne("admin.memberCount");
	}

	@Override
	public int tradePointCount() {
		return template.selectOne("admin.tradePointCount"); 
	}

	@Override
	public MemberListVO readMemberList(int nowPage) {
		MemberListVO mListVO=null;
		int totalMemberCount=template.selectOne("admin.memberCount");
		MemberPagingBean mPb=null;
		if(nowPage==1) {
			mPb=new MemberPagingBean(totalMemberCount);
		}else {
			mPb=new MemberPagingBean(totalMemberCount, nowPage);
		}
		List<MemberVO> list=template.selectList("admin.readMemberList",mPb);
		mListVO=new MemberListVO(list, mPb);
		return mListVO;
	}
}
