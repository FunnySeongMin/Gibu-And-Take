package org.kosta.gat.model.vo.post.application;

import java.util.List;

public class ApplicationPostListVO {
	private List<ApplicationPostVO>appPostVO;
	private ApplicationPostPagingBean appPb;
	
	public ApplicationPostListVO() {
		super();
	}
	public ApplicationPostListVO(List<ApplicationPostVO> appPostVO, ApplicationPostPagingBean appPb) {
		super();
		this.appPostVO = appPostVO;
		this.appPb = appPb;
	}
	public List<ApplicationPostVO> getAppPostVO() {
		return appPostVO;
	}
	public void setAppPostVO(List<ApplicationPostVO> appPostVO) {
		this.appPostVO = appPostVO;
	}
	public ApplicationPostPagingBean getAppPb() {
		return appPb;
	}
	public void setAppPb(ApplicationPostPagingBean appPb) {
		this.appPb = appPb;
	}
	@Override
	public String toString() {
		return "ApplicationPostListVO [appPostVO=" + appPostVO + ", appPb=" + appPb + "]";
	}
}
