package org.kosta.gat.model.vo.post.mileagetrade;

public class MileageUseGroupVO {
	private String mugNo;
	private String mugName;
	
	public MileageUseGroupVO() {
		super();
	}
	public MileageUseGroupVO(String mugNo, String mugName) {
		super();
		this.mugNo = mugNo;
		this.mugName = mugName;
	}
	public String getMugNo() {
		return mugNo;
	}
	public void setMugNo(String mugNo) {
		this.mugNo = mugNo;
	}
	public String getMugName() {
		return mugName;
	}
	public void setMugName(String mugName) {
		this.mugName = mugName;
	}
	@Override
	public String toString() {
		return "MileageUseGroup [mugNo=" + mugNo + ", mugName=" + mugName + "]";
	}
}
