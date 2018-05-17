package org.kosta.gat.model.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.gat.model.dao.DonationDAO;
import org.kosta.gat.model.dao.PhotoVo;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.application.PresentVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
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

	@Override
	public DonationPostVO readDonationDetail(String dpno) {
		return donationDAO.readDonationDetail(dpno);
	}

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
	public void file_upload_save(MultipartFile uploadfile, ModelMap modelMap) {
		donationDAO.file_upload_save(uploadfile, modelMap);
		
	}

	@Override
	public void addPresent(ArrayList<PresentVO> list) {
		donationDAO.addPresent(list);
		
	}
}
