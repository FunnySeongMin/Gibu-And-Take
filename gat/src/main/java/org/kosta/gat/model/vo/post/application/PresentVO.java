package org.kosta.gat.model.vo.post.application;

public class PresentVO {
	private String presentNo;
	private int donationMileage;
	private String presentContents;
	
	public PresentVO() {
		super();
	}
	public PresentVO(String presentNo, int donationMileage, String presentContents) {
		super();
		this.presentNo = presentNo;
		this.donationMileage = donationMileage;
		this.presentContents = presentContents;
	}
	public String getPresentNo() {
		return presentNo;
	}
	public void setPresentNo(String presentNo) {
		this.presentNo = presentNo;
	}
	public int getDonationMileage() {
		return donationMileage;
	}
	public void setDonationMileage(int donationMileage) {
		this.donationMileage = donationMileage;
	}
	public String getPresentContents() {
		return presentContents;
	}
	public void setPresentContents(String presentContents) {
		this.presentContents = presentContents;
	}
	@Override
	public String toString() {
		return "PresentVO [presentNo=" + presentNo + ", donationMileage=" + donationMileage + ", presentContents="
				+ presentContents + "]";
	}
}
