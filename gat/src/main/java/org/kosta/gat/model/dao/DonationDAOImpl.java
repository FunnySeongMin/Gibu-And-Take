package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostPagingBean;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostPagingBean;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DonationDAOImpl implements DonationDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public DonationPostListVO readDonationList(int nowPage) {
		DonationPostPagingBean dpPb=null;
		//재능기부 목록 총 게시글 수
		int totalDonationPostCount=template.selectOne("donation.totalDonationPostCount");
		if(nowPage==0) {
			dpPb=new DonationPostPagingBean(totalDonationPostCount);
		}else {
			dpPb=new DonationPostPagingBean(totalDonationPostCount, nowPage);
		}
		List<DonationPostVO> dpList=template.selectList("donation.readDonationList",dpPb);
		DonationPostListVO dpListVO=new DonationPostListVO(dpList, dpPb);
		return dpListVO;
	}

	@Override
	public DonationPostVO readDonationDetail(String dpno) {
		return template.selectOne("donation.readDonationDetail", dpno);
	}

	@Override
	public ReviewPostListVO readDonationReviewList(String dpno,int nowPage) {
		ReviewPostPagingBean rpPb=null;
		//해당 후기글의 총 게시글 수
		int totalDonationReviewCount=template.selectOne("donation.totalDonationReviewCount", dpno);
		if(nowPage==0) {
			rpPb=new ReviewPostPagingBean(totalDonationReviewCount);
		}else {
			rpPb=new ReviewPostPagingBean(totalDonationReviewCount, nowPage);
		}
		rpPb.setId(dpno);
		List<ReviewPostVO> rpList=template.selectList("donation.readDonationReviewList", rpPb);
		ReviewPostListVO rpListVO=new ReviewPostListVO(rpList, rpPb);
		return rpListVO;
	}

	@Override
	public ReviewPostVO readReviewDetail(String rpno) {
		return template.selectOne("donation.readReviewDetail", rpno);
	}

	@Override
	public void addApplication(ApplicationPostVO apVO) {
		template.insert("donation.addApplication", apVO);
	}

	@Override
	public void updateApplication(ApplicationPostVO apVO) {
		template.update("donation.updateApplication", apVO);
	}
}
