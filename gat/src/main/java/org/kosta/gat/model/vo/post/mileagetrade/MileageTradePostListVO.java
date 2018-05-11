package org.kosta.gat.model.vo.post.mileagetrade;

import java.util.ArrayList;

public class MileageTradePostListVO {
	private ArrayList<MileageTradeVO> mtVO;
	private MileageTradePostPagingBean mtPb;
	
	public MileageTradePostListVO() {
		super();
	}
	public MileageTradePostListVO(ArrayList<MileageTradeVO> mtVO, MileageTradePostPagingBean mtPb) {
		super();
		this.mtVO = mtVO;
		this.mtPb = mtPb;
	}
	public ArrayList<MileageTradeVO> getMtVO() {
		return mtVO;
	}
	public void setMtVO(ArrayList<MileageTradeVO> mtVO) {
		this.mtVO = mtVO;
	}
	public MileageTradePostPagingBean getMtPb() {
		return mtPb;
	}
	public void setMtPb(MileageTradePostPagingBean mtPb) {
		this.mtPb = mtPb;
	}
	@Override
	public String toString() {
		return "MileageTradePostListVO [mtVO=" + mtVO + ", mtPb=" + mtPb + "]";
	}
}
