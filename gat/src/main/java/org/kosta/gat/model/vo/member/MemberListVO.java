package org.kosta.gat.model.vo.member;

import java.util.List;

public class MemberListVO {
	private List<MemberVO> mlist;
	private MemberPagingBean mPb;
	
	public MemberListVO() {
		super();
	}
	public MemberListVO(List<MemberVO> mlist, MemberPagingBean mPb) {
		super();
		this.mlist = mlist;
		this.mPb = mPb;
	}
	public List<MemberVO> getMlist() {
		return mlist;
	}
	public void setMlist(List<MemberVO> mlist) {
		this.mlist = mlist;
	}
	public MemberPagingBean getmPb() {
		return mPb;
	}
	public void setmPb(MemberPagingBean mPb) {
		this.mPb = mPb;
	}
	@Override
	public String toString() {
		return "MemberListVO [mlist=" + mlist + ", mPb=" + mPb + "]";
	}
}
