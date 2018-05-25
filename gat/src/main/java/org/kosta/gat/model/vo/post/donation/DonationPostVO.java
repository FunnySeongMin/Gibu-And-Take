package org.kosta.gat.model.vo.post.donation;

import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;

public class DonationPostVO {
	private String dpNo;
	private String dpTitle;
	private String dpSummery;
	private String dpContents;
	private String place;
	private String dpImgDirectory;
	private String dpRegdate;
	private String startDate;
	private String endDate;
	private int dpCount;
	private int goalMileage;
	private int donationMileage;
	private int totalEntry;
	private int dpStatus;
	private ApplicationPostVO appPostVO;
	private MemberVO memberVO;
	
	public DonationPostVO() {
		super();
	}
	public DonationPostVO(String dpNo, String dpTitle, String dpSummery, String dpContents, String place,
			String dpImgDirectory, String dpRegdate, String startDate, String endDate, int dpCount, int goalMileage,
			int donationMileage, int totalEntry, int dpStatus, ApplicationPostVO appPostVO, MemberVO memberVO) {
		super();
		this.dpNo = dpNo;
		this.dpTitle = dpTitle;
		this.dpSummery = dpSummery;
		this.dpContents = dpContents;
		this.place = place;
		this.dpImgDirectory = dpImgDirectory;
		this.dpRegdate = dpRegdate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dpCount = dpCount;
		this.goalMileage = goalMileage;
		this.donationMileage = donationMileage;
		this.totalEntry = totalEntry;
		this.dpStatus = dpStatus;
		this.appPostVO = appPostVO;
		this.memberVO = memberVO;
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
	public String getDpSummery() {
		return dpSummery;
	}
	public void setDpSummery(String dpSummery) {
		this.dpSummery = dpSummery;
	}
	public String getDpContents() {
		return dpContents;
	}
	public void setDpContents(String dpContents) {
		this.dpContents = dpContents;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDpImgDirectory() {
		return dpImgDirectory;
	}
	public void setDpImgDirectory(String dpImgDirectory) {
		this.dpImgDirectory = dpImgDirectory;
	}
	public String getDpRegdate() {
		return dpRegdate;
	}
	public void setDpRegdate(String dpRegdate) {
		this.dpRegdate = dpRegdate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public int getDpStatus() {
		return dpStatus;
	}
	public void setDpStatus(int dpStatus) {
		this.dpStatus = dpStatus;
	}
	public ApplicationPostVO getAppPostVO() {
		return appPostVO;
	}
	public void setAppPostVO(ApplicationPostVO appPostVO) {
		this.appPostVO = appPostVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "DonationPostVO [dpNo=" + dpNo + ", dpTitle=" + dpTitle + ", dpSummery=" + dpSummery + ", dpContents="
				+ dpContents + ", place=" + place + ", dpImgDirectory=" + dpImgDirectory + ", dpRegdate=" + dpRegdate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", dpCount=" + dpCount + ", goalMileage="
				+ goalMileage + ", donationMileage=" + donationMileage + ", totalEntry=" + totalEntry + ", dpStatus="
				+ dpStatus + ", appPostVO=" + appPostVO + ", memberVO=" + memberVO + "]";
	}
}
