package org.kosta.gat.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.gat.model.dao.DonationDAO;
import org.kosta.gat.model.dao.PhotoVo;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.application.PresentVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostPagingBean;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DonationServiceImpl implements DonationService {
	@Resource
	private DonationDAO donationDAO;

	@Override
	public DonationPostListVO readDonationList(int nowPage) {
		return donationDAO.readDonationList(nowPage);
	}

	// 해당 재능기부 상세보기
	@Override
	public DonationPostVO readDonationDetail(String dpno) {
		return donationDAO.readDonationDetail(dpno);
	}
	
	@Override
	public List<TakeDonationPostVO> readDonationCheerUpMessageList(String dpno) {
		return donationDAO.readDonationCheerUpMessageList(dpno);
	}
	
	// 해당 재능기부 후기 목록
	@Override
	public ReviewPostListVO readDonationReviewList(String dpno,int nowPage) {
		return donationDAO.readDonationReviewList(dpno,nowPage);
	}

	@Override
	public ReviewPostVO readReviewDetail(String rpno) {
		return donationDAO.readReviewDetail(rpno);
	}

	@Override
	@Transactional
	public String  addApplication(ApplicationPostVO apVO) {
		return donationDAO.addApplication(apVO);
	}

	@Override
	@Transactional
	public void updateApplication(ApplicationPostVO apVO) {
		donationDAO.updateApplication(apVO);
	}

	@Override
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		donationDAO.multiplePhotoUpload(request, response);
		
	}

	@Override
	public void photoUpload(HttpServletRequest request, PhotoVo vo) {
		donationDAO.photoUpload(request, vo);
		
	}

	@Override
	public String file_upload_save(MultipartFile uploadfile, ModelMap modelMap) {
		return donationDAO.file_upload_save(uploadfile, modelMap);
		
	}

	@Override
	public void addPresent(ArrayList<PresentVO> list) {
		donationDAO.addPresent(list);
		
	}

	@Override
	public List<Map<String, Object>> DonationListView(DonationPostPagingBean dpPb) {
		return donationDAO.DonationListView(dpPb);
	}

	@Override
	public List<Map<String, Object>> DonationListView2() {
		return donationDAO.DonationListView2();
	}

	@Override
	public List<Map<String, Object>> DonationListRank() {
		return donationDAO.DonationListRank();
	}
	/*@Override
	public List<ReviewPostVO> readDonationReviewList(String dpno) {
		return donationDAO.readDonationReviewList(dpno);
	}*/

	@Override
	public ApplicationPostVO modifyApplyDonationView(String apno) {
		// TODO Auto-generated method stub
		return donationDAO.modifyApplyDonationView(apno);
	}

	@Override
	public String modifyApplyDonation(ApplicationPostVO apVO) {
		return donationDAO.modifyApplyDonation(apVO);
	}


}
