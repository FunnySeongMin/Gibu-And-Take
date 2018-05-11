package org.kosta.gat.model.vo.post.review;

import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;

public class ReviewPostVO {
	private String rpNo;
	private String rpTitle;
	private String rpContents;
	private String rpRegdate;
	private int rpRate;
	private MemberVO memberVO;
	private TakeDonationPostVO tdpVO;
	private DonationPostVO dpVO;
	
	public ReviewPostVO() {
		super();
	}
	public ReviewPostVO(String rpNo, String rpTitle, String rpContents, String rpRegdate, int rpRate, MemberVO memberVO,
			TakeDonationPostVO tdpVO, DonationPostVO dpVO) {
		super();
		this.rpNo = rpNo;
		this.rpTitle = rpTitle;
		this.rpContents = rpContents;
		this.rpRegdate = rpRegdate;
		this.rpRate = rpRate;
		this.memberVO = memberVO;
		this.tdpVO = tdpVO;
		this.dpVO = dpVO;
	}
	public String getRpNo() {
		return rpNo;
	}
	public void setRpNo(String rpNo) {
		this.rpNo = rpNo;
	}
	public String getRpTitle() {
		return rpTitle;
	}
	public void setRpTitle(String rpTitle) {
		this.rpTitle = rpTitle;
	}
	public String getRpContents() {
		return rpContents;
	}
	public void setRpContents(String rpContents) {
		this.rpContents = rpContents;
	}
	public String getRpRegdate() {
		return rpRegdate;
	}
	public void setRpRegdate(String rpRegdate) {
		this.rpRegdate = rpRegdate;
	}
	public int getRpRate() {
		return rpRate;
	}
	public void setRpRate(int rpRate) {
		this.rpRate = rpRate;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public TakeDonationPostVO getTdpVO() {
		return tdpVO;
	}
	public void setTdpVO(TakeDonationPostVO tdpVO) {
		this.tdpVO = tdpVO;
	}
	public DonationPostVO getDpVO() {
		return dpVO;
	}
	public void setDpVO(DonationPostVO dpVO) {
		this.dpVO = dpVO;
	}
	@Override
	public String toString() {
		return "ReviewPostVO [rpNo=" + rpNo + ", rpTitle=" + rpTitle + ", rpContents=" + rpContents + ", rpRegdate="
				+ rpRegdate + ", rpRate=" + rpRate + ", memberVO=" + memberVO + ", tdpVO=" + tdpVO + ", dpVO=" + dpVO
				+ "]";
	}
}
