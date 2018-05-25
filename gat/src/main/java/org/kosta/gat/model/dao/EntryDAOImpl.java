package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostPagingBean;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntryDAOImpl implements EntryDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void addTakeDonation(TakeDonationPostVO tdVO) {
		template.insert("entry.addTakeDonation", tdVO);
	}

	@Override
	public void addReview(ReviewPostVO rpVO) {
		template.insert("entry.addReview", rpVO);
	}

	// 해당 재능기부에 응원메시지 목록
	@Override
	public TakeDonationPostListVO findCheerupMessageByDpno(String dpno, int nowPage) {
		TakeDonationPostPagingBean tdPb = null;
		
		//해당 후기글의 총 게시글 수
		int totalCheerUpMsgCount=template.selectOne("entry.totalCheerUpMsgCount", dpno);
		if(nowPage==0) {
			tdPb=new TakeDonationPostPagingBean(totalCheerUpMsgCount);
		}else {
			tdPb=new TakeDonationPostPagingBean(totalCheerUpMsgCount, nowPage);
		}
		tdPb.setId(dpno);
		List<TakeDonationPostVO> tdList=  template.selectList("entry.findCheerupMessageByDpno", tdPb);
		TakeDonationPostListVO tdpListVO = new TakeDonationPostListVO(tdList, tdPb);

		return tdpListVO;
	}

	public TakeDonationPostVO findEntryByIdAndDpno(TakeDonationPostVO tdVO) {
		return template.selectOne("entry.findEntryByIdAndDpno",tdVO);
	}
	
	/*@Override
	public List<TakeDonationPostVO> findEntryByIdAndDpno(TakeDonationPostVO tdVO) {
		return template.selectList("entry.findEntryByIdAndDpno",tdVO);
	}
	*/
}
