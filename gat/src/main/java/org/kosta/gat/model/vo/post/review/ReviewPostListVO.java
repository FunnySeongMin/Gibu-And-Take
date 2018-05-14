package org.kosta.gat.model.vo.post.review;

import java.util.List;

public class ReviewPostListVO {
	private List<ReviewPostVO> list;
	private ReviewPostPagingBean rpPb;
	
	public ReviewPostListVO() {
		super();
	}
	public ReviewPostListVO(List<ReviewPostVO> list, ReviewPostPagingBean rpPb) {
		super();
		this.list = list;
		this.rpPb = rpPb;
	}
	public List<ReviewPostVO> getList() {
		return list;
	}
	public void setList(List<ReviewPostVO> list) {
		this.list = list;
	}
	public ReviewPostPagingBean getRpPb() {
		return rpPb;
	}
	public void setRpPb(ReviewPostPagingBean rpPb) {
		this.rpPb = rpPb;
	}
	@Override
	public String toString() {
		return "ReviewPostListVO [list=" + list + ", rpPb=" + rpPb + "]";
	}
}
