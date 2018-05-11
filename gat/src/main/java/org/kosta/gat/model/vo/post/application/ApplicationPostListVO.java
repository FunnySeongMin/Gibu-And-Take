package org.kosta.gat.model.vo.post.application;

import java.util.ArrayList;

public class ApplicationPostListVO {
	private ArrayList<ApplicationPostVO>appPostVO;
	private ApplicationPostPagingBean appPb;
	
	public ApplicationPostListVO() {
		super();
	}
	public ApplicationPostListVO(ArrayList<ApplicationPostVO> appPostVO, ApplicationPostPagingBean appPb) {
		super();
		this.appPostVO = appPostVO;
		this.appPb = appPb;
	}
	public ArrayList<ApplicationPostVO> getAppPostVO() {
		return appPostVO;
	}
	public void setAppPostVO(ArrayList<ApplicationPostVO> appPostVO) {
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
