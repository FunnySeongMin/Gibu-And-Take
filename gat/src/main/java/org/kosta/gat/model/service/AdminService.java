package org.kosta.gat.model.service;

import org.kosta.gat.model.vo.post.application.ApplicationPostListVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;

public interface AdminService {

	public ApplicationPostListVO readUnReceivedApplicationList(int nowPage);

	public ApplicationPostVO readUnReceivedApplicationDetail(String apno);

	public void updateUnReceivedApplication(String apno,String command);

	public void addApplicationAnswer(ApplicationPostVO apVO);

	public void addDonationPost(ApplicationPostVO apVO);

	public WebQuestionPostListVO readWebQuestionList(int nowPage);

	public WebQuestionPostVO readWebQuestionDetail(String wqno);

	public void addWebQuestionAnswer(WebQuestionPostVO wqVO);

	public void updateWebQuestionAnswer(WebQuestionPostVO wqVO);

}
