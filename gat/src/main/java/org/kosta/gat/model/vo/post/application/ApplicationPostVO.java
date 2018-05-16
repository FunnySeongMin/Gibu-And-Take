package org.kosta.gat.model.vo.post.application;

import java.util.ArrayList;

import org.kosta.gat.model.vo.member.MemberVO;

public class ApplicationPostVO {
	private String appNo;
	private String appTitle;
	private String appContents;
	private String place;
	private String appRegdate;
	private String startDate;
	private String endDate;
	private int goalMileage;
	private String appStatus;
	private String appParentNo;
	private AppGroupVO appGroupVO;
	private ArrayList<AttachmentVO> attList;
	private ArrayList<PresentVO> presentList;
	private MemberVO memberVO;
	
	public ApplicationPostVO() {
		super();
	}
	public ApplicationPostVO(String appNo, String appTitle, String appContents, String place, String appRegdate,
			String startDate, String endDate, int goalMileage, String appStatus, String appParentNo,
			AppGroupVO appGroupVO, ArrayList<AttachmentVO> attList, ArrayList<PresentVO> presentList,
			MemberVO memberVO) {
		super();
		this.appNo = appNo;
		this.appTitle = appTitle;
		this.appContents = appContents;
		this.place = place;
		this.appRegdate = appRegdate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goalMileage = goalMileage;
		this.appStatus = appStatus;
		this.appParentNo = appParentNo;
		this.appGroupVO = appGroupVO;
		this.attList = attList;
		this.presentList = presentList;
		this.memberVO = memberVO;
	}
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public String getAppTitle() {
		return appTitle;
	}
	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}
	public String getAppContents() {
		return appContents;
	}
	public void setAppContents(String appContents) {
		this.appContents = appContents;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAppRegdate() {
		return appRegdate;
	}
	public void setAppRegdate(String appRegdate) {
		this.appRegdate = appRegdate;
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
	public int getGoalMileage() {
		return goalMileage;
	}
	public void setGoalMileage(int goalMileage) {
		this.goalMileage = goalMileage;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getAppParentNo() {
		return appParentNo;
	}
	public void setAppParentNo(String appParentNo) {
		this.appParentNo = appParentNo;
	}
	public AppGroupVO getAppGroupVO() {
		return appGroupVO;
	}
	public void setAppGroupVO(AppGroupVO appGroupVO) {
		this.appGroupVO = appGroupVO;
	}
	public ArrayList<AttachmentVO> getAttList() {
		return attList;
	}
	public void setAttList(ArrayList<AttachmentVO> attList) {
		this.attList = attList;
	}
	public ArrayList<PresentVO> getPresentList() {
		return presentList;
	}
	public void setPresentList(ArrayList<PresentVO> presentList) {
		this.presentList = presentList;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "ApplicationPostVO [appNo=" + appNo + ", appTitle=" + appTitle + ", appContents=" + appContents
				+ ", place=" + place + ", appRegdate=" + appRegdate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", goalMileage=" + goalMileage + ", appStatus=" + appStatus + ", appParentNo=" + appParentNo
				+ ", appGroupVO=" + appGroupVO + ", attList=" + attList + ", presentList=" + presentList + ", memberVO="
				+ memberVO + "]";
	}
}
