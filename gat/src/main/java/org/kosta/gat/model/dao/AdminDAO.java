package org.kosta.gat.model.dao;

import org.kosta.gat.model.vo.member.MemberListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;

public interface AdminDAO {

	public ApplicationPostListVO readUnReceivedApplicationList(int nowPage);

	public ApplicationPostVO readUnReceivedApplicationDetail(String apno);

	public void updateUnReceivedApplication(String apno, String command);

	public void addApplicationAnswer(ApplicationPostVO apVO);

	public void addDonationPost(ApplicationPostVO apVO);

	public WebQuestionPostListVO readWebQuestionList(int nowPage);

	public WebQuestionPostVO readWebQuestionDetail(String wqno);

	public void addWebQuestionAnswer(WebQuestionPostVO wqVO);

	public void updateWebQuestionAnswer(WebQuestionPostVO wqVO);

	public int appCount();

	public int questionCount();

	public int memberCount();

	public int tradePointCount(); 

	public MemberListVO readMemberList(int nowPage);

}
