package org.kosta.gat.model.vo.post.webquestion;

import org.kosta.gat.model.vo.member.MemberVO;

public class WebQuestionPostVO {
	private int wqNo;
	private int thread;
	private String wqTitle;
	private String wqContents;
	private String wqRegdate;
	private String wqParentNo;
	private String wqStatus;
	private MemberVO memberVO;
	
	public boolean isAnswer() { 
		int num=this.thread%100;
		if(num==0) { //답변이 아님
			return true;
		}else { //답변임
			return false;
		}
	}
	
	public WebQuestionPostVO() {
		super();
	}

	public WebQuestionPostVO(String wqTitle, String wqContents, String wqRegdate, String wqParentNo, String wqStatus,
			MemberVO memberVO) {
		super();
		this.wqTitle = wqTitle;
		this.wqContents = wqContents;
		this.wqRegdate = wqRegdate;
		this.wqParentNo = wqParentNo;
		this.wqStatus = wqStatus;
		this.memberVO = memberVO;
	}

	public WebQuestionPostVO(int wqNo,int thread, String wqTitle, String wqContents, String wqRegdate, String wqParentNo,
			String wqStatus, MemberVO memberVO) {
		super();
		this.wqNo = wqNo;
		this.thread = thread;
		this.wqTitle = wqTitle;
		this.wqContents = wqContents;
		this.wqRegdate = wqRegdate;
		this.wqParentNo = wqParentNo;
		this.wqStatus = wqStatus;
		this.memberVO = memberVO;
	}
	public int getWqNo() {
		return wqNo;
	}
	public void setWqNo(int wqNo) {
		this.wqNo = wqNo;
	}
	public int getThread() {
		return thread;
	}
	public void setThread(int thread) {
		this.thread = thread;
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
		return "WebQuestionPostVO [wqNo=" + wqNo + ", thread=" + thread + ", wqTitle=" + wqTitle + ", wqContents="
				+ wqContents + ", wqRegdate=" + wqRegdate + ", wqParentNo=" + wqParentNo + ", wqStatus=" + wqStatus
				+ ", memberVO=" + memberVO + "]";
	}
}
