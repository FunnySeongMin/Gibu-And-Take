package org.kosta.gat.model.vo.post.donation;

import org.kosta.gat.model.vo.post.application.ApplicationPostVO;

public class DonationPostVO {
	private String dpNo;
	private String dpTitle;
	private String dpContents;
	private String dpRegdate;
	private int dpCount;
	private int goalMileage;
	private int donationMileage;
	private int totalEntry;
	private ApplicationPostVO appPostVO;
	
	public DonationPostVO() {
		super();
	}
	public DonationPostVO(String dpNo, String dpTitle, String dpContents, String dpRegdate, int dpCount,
			int goalMileage, int donationMileage, int totalEntry, ApplicationPostVO appPostVO) {
		super();
		this.dpNo = dpNo;
		this.dpTitle = dpTitle;
		this.dpContents = dpContents;
		this.dpRegdate = dpRegdate;
		this.dpCount = dpCount;
		this.goalMileage = goalMileage;
		this.donationMileage = donationMileage;
		this.totalEntry = totalEntry;
		this.appPostVO = appPostVO;
	}
	public String getDpNo() {
		return dpNo;
	}
	public void setDpNo(String dpNo) {
		this.dpNo = dpNo;
	}
	public String getDpTitle() {
		return dpTitle;
	}
	public void setDpTitle(String dpTitle) {
		this.dpTitle = dpTitle;
	}
	public String getDpContents() {
		return dpContents;
	}
	public void setDpContents(String dpContents) {
		this.dpContents = dpContents;
	}
	public String getDpRegdate() {
		return dpRegdate;
	}
	public void setDpRegdate(String dpRegdate) {
		this.dpRegdate = dpRegdate;
	}
	public int getDpCount() {
		return dpCount;
	}
	public void setDpCount(int dpCount) {
		this.dpCount = dpCount;
	}
	public int getGoalMileage() {
		return goalMileage;
	}
	public void setGoalMileage(int goalMileage) {
		this.goalMileage = goalMileage;
	}
	public int getDonationMileage() {
		return donationMileage;
	}
	public void setDonationMileage(int donationMileage) {
		this.donationMileage = donationMileage;
	}
	public int getTotalEntry() {
		return totalEntry;
	}
	public void setTotalEntry(int totalEntry) {
		this.totalEntry = totalEntry;
	}
	public ApplicationPostVO getAppPostVO() {
		return appPostVO;
	}
	public void setAppPostVO(ApplicationPostVO appPostVO) {
		this.appPostVO = appPostVO;
	}
	@Override
	public String toString() {
		return "DonationPostVO [dpNo=" + dpNo + ", dpTitle=" + dpTitle + ", dpContents=" + dpContents + ", dpRegdate="
				+ dpRegdate + ", dpCount=" + dpCount + ", goalMileage=" + goalMileage + ", donationMileage="
				+ donationMileage + ", totalEntry=" + totalEntry + ", appPostVO=" + appPostVO + "]";
	}
}
