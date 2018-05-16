package org.kosta.gat.model.dao;

import java.util.List;

import org.kosta.gat.model.vo.member.MemberVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostPagingBean;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostListVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostPagingBean;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostListVO;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostPagingBean;
import org.kosta.gat.model.vo.post.webquestion.WebQuestionPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void registerMember(MemberVO vo) {
		template.insert("member.registerMember", vo);
	}

	@Override
	public MemberVO checkId(String id) {
		return template.selectOne("member.checkId", id);
	}

	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("멤버DAO까지 들어옴");
		template.update("member.updateMember", vo);
	}
	
	@Override
	public void deleteMember(String id) {
		template.delete("member.deleteMember", id);
	}
	
	@Override
	public void addWebQuestion(WebQuestionPostVO webVO) {
		template.insert("member.addWebQuestion", webVO);
	}

	@Override
	public WebQuestionPostListVO readWebQuestion(int nowPage) {
		WebQuestionPostPagingBean wqPb=null;
		//총 문의글의 개수를 가져오는 메서드
		int totalWebQuestionCount=template.selectOne("member.totalWebQuestionCount");
		if(nowPage==0) {
			wqPb=new WebQuestionPostPagingBean(totalWebQuestionCount);
		}else {
			wqPb= new WebQuestionPostPagingBean(totalWebQuestionCount, nowPage);
		}
		List<WebQuestionPostVO> list=template.selectList("member.WebQuestionPostList",wqPb);
		WebQuestionPostListVO wqListVO=new WebQuestionPostListVO(list, wqPb);
		return wqListVO;
	}

	@Override
	public void updateWebQuestion(WebQuestionPostVO wqVO) {
		template.update("member.updateWebQuestion", wqVO);
	}

	@Override
	public void deleteWebQuestion() {
		template.delete("member.deleteWebQuestion");
	}

	@Override
	public ReviewPostListVO readMyReviewPostList(String id, int nowPage) {
		ReviewPostPagingBean rpPb=null;
		//나의 후기글 목록의 수를 가져온다.
		int totalMyReviewPostCount=template.selectOne("member.totalMyReviewPostCount", id);
		if(nowPage==0) {
			rpPb=new ReviewPostPagingBean(totalMyReviewPostCount);
		}else {
			rpPb=new ReviewPostPagingBean(totalMyReviewPostCount, nowPage);
		}
		rpPb.setId(id);
		List<ReviewPostVO> rpList=template.selectList("member.readMyReviewPostList", rpPb);
		ReviewPostListVO rpListVO=new ReviewPostListVO(rpList, rpPb);
		return rpListVO;
	}

	@Override
	public TakeDonationPostListVO readMyActivityList(String id, int nowPage) {
		TakeDonationPostPagingBean tdPb=null;
		//나의 활동 총 숫자를 가져온다.
		int totalMyActivityCount=template.selectOne("member.totalMyActivityCount", id);
		if(nowPage==0) {
			tdPb=new TakeDonationPostPagingBean(totalMyActivityCount);
		}else {
			tdPb=new TakeDonationPostPagingBean(totalMyActivityCount, nowPage);
		}
		tdPb.setId(id);
		List<TakeDonationPostVO> tdList=template.selectList("member.readMyActivityList",tdPb);
		TakeDonationPostListVO tdListVO=new TakeDonationPostListVO(tdList, tdPb);
		return tdListVO;
	}
}
