package org.kosta.gat.model.vo.post.application;

public class AppGroupVO {
	private String agNo;
	private String agName;
	
	public AppGroupVO() {
		super();
	}
	public AppGroupVO(String agNo, String agName) {
		super();
		this.agNo = agNo;
		this.agName = agName;
	}
	public String getAgNo() {
		return agNo;
	}
	public void setAgNo(String agNo) {
		this.agNo = agNo;
	}
	public String getAgName() {
		return agName;
	}
	public void setAgName(String agName) {
		this.agName = agName;
	}
	@Override
	public String toString() {
		return "AppGroupVO [agNo=" + agNo + ", agName=" + agName + "]";
	}
}
