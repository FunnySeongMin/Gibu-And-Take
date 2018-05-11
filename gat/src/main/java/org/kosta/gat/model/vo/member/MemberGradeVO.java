package org.kosta.gat.model.vo.member;

public class MemberGradeVO {
	private String mgradeNo;
	private String mgradeName;
	
	public MemberGradeVO() {
		super();
	}
	public MemberGradeVO(String mgradeNo, String mgradeName) {
		super();
		this.mgradeNo = mgradeNo;
		this.mgradeName = mgradeName;
	}
	public String getMgradeNo() {
		return mgradeNo;
	}
	public void setMgradeNo(String mgradeNo) {
		this.mgradeNo = mgradeNo;
	}
	public String getMgradeName() {
		return mgradeName;
	}
	public void setMgradeName(String mgradeName) {
		this.mgradeName = mgradeName;
	}
	@Override
	public String toString() {
		return "MemberGradeVO [mgradeNo=" + mgradeNo + ", mgradeName=" + mgradeName + "]";
	}
}
