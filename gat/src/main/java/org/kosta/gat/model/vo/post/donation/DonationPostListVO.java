package org.kosta.gat.model.vo.post.donation;

import java.util.List;

public class DonationPostListVO {
	private List<DonationPostVO> donationPostVO;
	private DonationPostPagingBean donationPostPb;
	
	public DonationPostListVO() {
		super();
	}
	public DonationPostListVO(List<DonationPostVO> donationPostVO, DonationPostPagingBean donationPostPb) {
		super();
		this.donationPostVO = donationPostVO;
		this.donationPostPb = donationPostPb;
	}
	public List<DonationPostVO> getDonationPostVO() {
		return donationPostVO;
	}
	public void setDonationPostVO(List<DonationPostVO> donationPostVO) {
		this.donationPostVO = donationPostVO;
	}
	public DonationPostPagingBean getDonationPostPb() {
		return donationPostPb;
	}
	public void setDonationPostPb(DonationPostPagingBean donationPostPb) {
		this.donationPostPb = donationPostPb;
	}
	@Override
	public String toString() {
		return "DonationPostListVO [donationPostVO=" + donationPostVO + ", donationPostPb=" + donationPostPb + "]";
	}
}
