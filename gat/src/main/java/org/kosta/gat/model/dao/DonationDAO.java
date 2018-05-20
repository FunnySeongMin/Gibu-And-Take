package org.kosta.gat.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.application.PresentVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostPagingBean;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

public interface DonationDAO {

	public DonationPostListVO readDonationList(int nowPage);

	public DonationPostVO readDonationDetail(String dpno);

	public ReviewPostListVO readDonationReviewList(String dpno,int nowPage);

	public ReviewPostVO readReviewDetail(String rpno);

	public String addApplication(ApplicationPostVO apVO);

	public void updateApplication(ApplicationPostVO apVO);
	
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response);

	public String photoUpload(HttpServletRequest request, PhotoVo vo);

	public String file_upload_save(MultipartFile uploadfile, ModelMap modelMap);

	public void addPresent(ArrayList<PresentVO> list);

	public List<Map<String, Object>> DonationListView(DonationPostPagingBean dpPb);

}
