package org.kosta.gat.model.vo.post.webquestion;

import org.kosta.gat.model.vo.member.MemberVO;

public class WebQuestionPostVO {
	private String wqNo;
	private String wqTitle;
	private String wqContents;
	private String wqRegdate;
	private String wqParentNo;
	private String wqStatus;
	private MemberVO memberVO;
	
	public WebQuestionPostVO() {
		super();
	}
	public WebQuestionPostVO(String wqNo, String wqTitle, String wqContents, String wqRegdate, String wqParentNo,
			String wqStatus, MemberVO memberVO) {
		super();
		this.wqNo = wqNo;
		this.wqTitle = wqTitle;
		this.wqContents = wqContents;
		this.wqRegdate = wqRegdate;
		this.wqParentNo = wqParentNo;
		this.wqStatus = wqStatus;
		this.memberVO = memberVO;
	}
	public String getWqNo() {
		return wqNo;
	}
	public void setWqNo(String wqNo) {
		this.wqNo = wqNo;
	}
	public String getWqTitle() {
		return wqTitle;
	}
	public void setWqTitle(String wqTitle) {
		this.wqTitle = wqTitle;
	}
	public String getWqContents() {
		return wqContents;
	}
	public void setWqContents(String wqContents) {
		this.wqContents = wqContents;
	}
	public String getWqRegdate() {
		return wqRegdate;
	}
	public void setWqRegdate(String wqRegdate) {
		this.wqRegdate = wqRegdate;
	}
	public String getWqParentNo() {
		return wqParentNo;
	}
	public void setWqParentNo(String wqParentNo) {
		this.wqParentNo = wqParentNo;
	}
	public String getWqStatus() {
		return wqStatus;
	}
	public void setWqStatus(String wqStatus) {
		this.wqStatus = wqStatus;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "WebQuestionPostVO [wqNo=" + wqNo + ", wqTitle=" + wqTitle + ", wqContents=" + wqContents
				+ ", wqRegdate=" + wqRegdate + ", wqParentNo=" + wqParentNo + ", wqStatus=" + wqStatus + ", memberVO="
				+ memberVO + "]";
	}
}
