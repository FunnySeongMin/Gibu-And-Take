package org.kosta.gat.model.vo.post.mileagetrade;

import org.kosta.gat.model.vo.member.MemberVO;

public class MileageTradeVO {
	private int mtNo;
	private int mtVolume;
	private String mtRegdate;
	private MileageUseGroupVO mugVO;
	private MemberVO memberVO;
	
	public MileageTradeVO() {
		super();
	}
	public MileageTradeVO(int mtNo, int mtVolume, String mtRegdate, MileageUseGroupVO mugVO, MemberVO memberVO) {
		super();
		this.mtNo = mtNo;
		this.mtVolume = mtVolume;
		this.mtRegdate = mtRegdate;
		this.mugVO = mugVO;
		this.memberVO = memberVO;
	}
	public int getMtNo() {
		return mtNo;
	}
	public void setMtNo(int mtNo) {
		this.mtNo = mtNo;
	}
	public int getMtVolume() {
		return mtVolume;
	}
	public void setMtVolume(int mtVolume) {
		this.mtVolume = mtVolume;
	}
	public String getMtRegdate() {
		return mtRegdate;
	}
	public void setMtRegdate(String mtRegdate) {
		this.mtRegdate = mtRegdate;
	}
	public MileageUseGroupVO getMugVO() {
		return mugVO;
	}
	public void setMugVO(MileageUseGroupVO mugVO) {
		this.mugVO = mugVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "MileageTradeVO [mtNo=" + mtNo + ", mtVolume=" + mtVolume + ", mtRegdate=" + mtRegdate + ", mugVO="
				+ mugVO + ", memberVO=" + memberVO + "]";
	}
}
