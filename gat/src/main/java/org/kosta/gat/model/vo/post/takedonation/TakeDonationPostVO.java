package org.kosta.gat.model.vo.post.takedonation;

import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;

public class TakeDonationPostVO {
	private int tdNo;
	private String tdRegdate;
	private int tdMileage;
	private String cheerUpMessage;
	private MemberVO memberVO;
	private DonationPostVO donationPostVO;
	
	public TakeDonationPostVO() {
		super();
	}
	public TakeDonationPostVO(int tdNo, String tdRegdate, int tdMileage, String cheerUpMessage, MemberVO memberVO,
			DonationPostVO donationPostVO) {
		super();
		this.tdNo = tdNo;
		this.tdRegdate = tdRegdate;
		this.tdMileage = tdMileage;
		this.cheerUpMessage = cheerUpMessage;
		this.memberVO = memberVO;
		this.donationPostVO = donationPostVO;
	}
	public int getTdNo() {
		return tdNo;
	}
	public void setTdNo(int tdNo) {
		this.tdNo = tdNo;
	}
	public String getTdRegdate() {
		return tdRegdate;
	}
	public void setTdRegdate(String tdRegdate) {
		this.tdRegdate = tdRegdate;
	}
	public int getTdMileage() {
		return tdMileage;
	}
	public void setTdMileage(int tdMileage) {
		this.tdMileage = tdMileage;
	}
	public String getCheerUpMessage() {
		return cheerUpMessage;
	}
	public void setCheerUpMessage(String cheerUpMessage) {
		this.cheerUpMessage = cheerUpMessage;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public DonationPostVO getDonationPostVO() {
		return donationPostVO;
	}
	public void setDonationPostVO(DonationPostVO donationPostVO) {
		this.donationPostVO = donationPostVO;
	}
	@Override
	public String toString() {
		return "TakeDonationPostVO [tdNo=" + tdNo + ", tdRegdate=" + tdRegdate + ", tdMileage=" + tdMileage
				+ ", cheerUpMessage=" + cheerUpMessage + ", memberVO=" + memberVO + ", donationPostVO=" + donationPostVO
				+ "]";
	}
}
