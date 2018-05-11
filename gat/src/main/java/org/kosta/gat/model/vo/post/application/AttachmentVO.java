package org.kosta.gat.model.vo.post.application;

public class AttachmentVO {
	private String achNo;
	private String achDirectory;
	private String achGrade;
	
	public AttachmentVO() {
		super();
	}
	public AttachmentVO(String achNo, String achDirectory, String achGrade) {
		super();
		this.achNo = achNo;
		this.achDirectory = achDirectory;
		this.achGrade = achGrade;
	}
	public String getAchNo() {
		return achNo;
	}
	public void setAchNo(String achNo) {
		this.achNo = achNo;
	}
	public String getAchDirectory() {
		return achDirectory;
	}
	public void setAchDirectory(String achDirectory) {
		this.achDirectory = achDirectory;
	}
	public String getAchGrade() {
		return achGrade;
	}
	public void setAchGrade(String achGrade) {
		this.achGrade = achGrade;
	}
	@Override
	public String toString() {
		return "AttachmentVO [achNo=" + achNo + ", achDirectory=" + achDirectory + ", achGrade=" + achGrade + "]";
	}
}
