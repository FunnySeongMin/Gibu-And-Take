package org.kosta.gat.model.vo.post.mileagetrade;

import java.util.List;

public class MileageTradePostListVO {
	private List<MileageTradeVO> mtVO;
	private MileageTradePostPagingBean mtPb;
	
	public MileageTradePostListVO() {
		super();
	}
	public MileageTradePostListVO(List<MileageTradeVO> mtVO, MileageTradePostPagingBean mtPb) {
		super();
		this.mtVO = mtVO;
		this.mtPb = mtPb;
	}
	public List<MileageTradeVO> getMtVO() {
		return mtVO;
	}
	public void setMtVO(List<MileageTradeVO> mtVO) {
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
