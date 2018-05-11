package org.kosta.gat.model.vo.post.takedonation;

import java.util.ArrayList;

public class TakeDonationPostListVO {
	private ArrayList<TakeDonationPostVO> tdpVO;
	private TakeDonationPostPagingBean tdpPb;
	
	public TakeDonationPostListVO() {
		super();
	}
	public TakeDonationPostListVO(ArrayList<TakeDonationPostVO> tdpVO, TakeDonationPostPagingBean tdpPb) {
		super();
		this.tdpVO = tdpVO;
		this.tdpPb = tdpPb;
	}
	public ArrayList<TakeDonationPostVO> getTdpVO() {
		return tdpVO;
	}
	public void setTdpVO(ArrayList<TakeDonationPostVO> tdpVO) {
		this.tdpVO = tdpVO;
	}
	public TakeDonationPostPagingBean getTdpPb() {
		return tdpPb;
	}
	public void setTdpPb(TakeDonationPostPagingBean tdpPb) {
		this.tdpPb = tdpPb;
	}
	@Override
	public String toString() {
		return "TakeDonationPostListVO [tdpVO=" + tdpVO + ", tdpPb=" + tdpPb + "]";
	}
}
