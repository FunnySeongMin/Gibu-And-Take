package org.kosta.gat.model.vo.post.takedonation;

import java.util.List;

public class TakeDonationPostListVO {
	private List<TakeDonationPostVO> tdpVO;
	private TakeDonationPostPagingBean tdpPb;
	
	public TakeDonationPostListVO() {
		super();
	}
	public TakeDonationPostListVO(List<TakeDonationPostVO> tdpVO, TakeDonationPostPagingBean tdpPb) {
		super();
		this.tdpVO = tdpVO;
		this.tdpPb = tdpPb;
	}
	public List<TakeDonationPostVO> getTdpVO() {
		return tdpVO;
	}
	public void setTdpVO(List<TakeDonationPostVO> tdpVO) {
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
