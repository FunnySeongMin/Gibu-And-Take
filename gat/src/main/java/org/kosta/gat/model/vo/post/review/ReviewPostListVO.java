package org.kosta.gat.model.vo.post.review;

import java.util.ArrayList;

public class ReviewPostListVO {
	private ArrayList<ReviewPostVO> list;
	private ReviewPostPagingBean rpPb;
	
	public ReviewPostListVO() {
		super();
	}
	public ReviewPostListVO(ArrayList<ReviewPostVO> list, ReviewPostPagingBean rpPb) {
		super();
		this.list = list;
		this.rpPb = rpPb;
	}
	public ArrayList<ReviewPostVO> getList() {
		return list;
	}
	public void setList(ArrayList<ReviewPostVO> list) {
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
