package org.kosta.gat.model.vo.post.webquestion;

import java.util.ArrayList;

public class WebQuestionPostListVO {
	private ArrayList<WebQuestionPostVO> wqPostVO;
	private WebQuestionPostPagingBean wqPb;
	
	public WebQuestionPostListVO() {
		super();
	}
	public WebQuestionPostListVO(ArrayList<WebQuestionPostVO> wqPostVO, WebQuestionPostPagingBean wqPb) {
		super();
		this.wqPostVO = wqPostVO;
		this.wqPb = wqPb;
	}
	public ArrayList<WebQuestionPostVO> getWqPostVO() {
		return wqPostVO;
	}
	public void setWqPostVO(ArrayList<WebQuestionPostVO> wqPostVO) {
		this.wqPostVO = wqPostVO;
	}
	public WebQuestionPostPagingBean getWqPb() {
		return wqPb;
	}
	public void setWqPb(WebQuestionPostPagingBean wqPb) {
		this.wqPb = wqPb;
	}
	@Override
	public String toString() {
		return "WebQuestionPostListVO [wqPostVO=" + wqPostVO + ", wqPb=" + wqPb + "]";
	}
}
