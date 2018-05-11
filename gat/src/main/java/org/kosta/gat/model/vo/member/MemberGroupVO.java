package org.kosta.gat.model.vo.member;

public class MemberGroupVO {
	private String mgroupNo;
	private String mgroupName;
	
	public MemberGroupVO() {
		super();
	}
	public MemberGroupVO(String mgroupNo, String mgroupName) {
		super();
		this.mgroupNo = mgroupNo;
		this.mgroupName = mgroupName;
	}
	public String getMgroupNo() {
		return mgroupNo;
	}
	public void setMgroupNo(String mgroupNo) {
		this.mgroupNo = mgroupNo;
	}
	public String getMgroupName() {
		return mgroupName;
	}
	public void setMgroupName(String mgroupName) {
		this.mgroupName = mgroupName;
	}
	@Override
	public String toString() {
		return "MemberGroupVO [mgroupNo=" + mgroupNo + ", mgroupName=" + mgroupName + "]";
	}
}
