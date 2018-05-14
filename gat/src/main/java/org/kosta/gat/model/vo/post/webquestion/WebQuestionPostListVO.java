package org.kosta.gat.model.vo.post.webquestion;

import java.util.List;

public class WebQuestionPostListVO {
	private List<WebQuestionPostVO> wqPostVO;
	private WebQuestionPostPagingBean wqPb;
	
	public WebQuestionPostListVO() {
		super();
	}
	public WebQuestionPostListVO(List<WebQuestionPostVO> wqPostVO, WebQuestionPostPagingBean wqPb) {
		super();
		this.wqPostVO = wqPostVO;
		this.wqPb = wqPb;
	}
	public List<WebQuestionPostVO> getWqPostVO() {
		return wqPostVO;
	}
	public void setWqPostVO(List<WebQuestionPostVO> wqPostVO) {
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
