package org.kosta.gat.model.vo.post.donation;

import java.util.ArrayList;

public class DonationPostListVO {
	private ArrayList<DonationPostVO> donationPostVO;
	private DonationPostPagingBean donationPostPb;
	
	public DonationPostListVO() {
		super();
	}
	public DonationPostListVO(ArrayList<DonationPostVO> donationPostVO, DonationPostPagingBean donationPostPb) {
		super();
		this.donationPostVO = donationPostVO;
		this.donationPostPb = donationPostPb;
	}
	public ArrayList<DonationPostVO> getDonationPostVO() {
		return donationPostVO;
	}
	public void setDonationPostVO(ArrayList<DonationPostVO> donationPostVO) {
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
