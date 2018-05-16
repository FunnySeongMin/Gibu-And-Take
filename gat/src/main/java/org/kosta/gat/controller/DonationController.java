package org.kosta.gat.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.gat.model.dao.PhotoVo;
import org.kosta.gat.model.service.DonationService;
import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DonationController {
	@Resource
	private DonationService donationService;
	
	/**
	* 작성이유 : 재능기부 목록보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readDonationList.do")
	public String readDonationList(int nowPage,Model model) {
		DonationPostListVO dpListVO=donationService.readDonationList(nowPage);
		return null;
	}
	/**
	* 작성이유 : 재능기부 상세보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readDonationDetail.do")
	public String readDonationDetail(String dpno,Model model) {
		DonationPostVO dpVO=donationService.readDonationDetail(dpno);
		return null;
	}
	/**
	* 작성이유 : 해당 재능기부 후기게시판 보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readDonationReviewList.do")
	public String readDonationReviewList(String dpno,int nowPage,Model model) {
		ReviewPostListVO rpListVO=donationService.readDonationReviewList(dpno,nowPage);
		return null;
	}
	/**
	* 작성이유 : 해당 재능기부 후기게시판 상세보기
	* 
	* @author 은성민
	*/
	@RequestMapping("readReviewDetail.do")
	public String readReviewDetail(String rpno,Model model) {
		ReviewPostVO rpVO=donationService.readReviewDetail(rpno);
		return null;
	}
	/**
	* 작성이유 : 재능기부 신청서 작성
	* 
	* @author 정진표
	*/
	@RequestMapping("/board/addApplication.do")
	public String addApplication(ApplicationPostVO apVO, HttpServletRequest request, Model model) {
		//donationService.addApplication(apVO);
		System.out.println("apVO : "+apVO);
		System.out.println("글쓰기:"+request.getParameter("appContents"));
		//model.addAttribute("test",request.getParameter("editor") );
		return "home.tiles";
	}
	
	//단일파일업로드
	@RequestMapping("photoUpload.do")
	public void photoUpload(HttpServletRequest request, PhotoVo vo){
		donationService.photoUpload(request, vo);
	}
	//다중파일업로드
	@RequestMapping("multiplePhotoUpload.do")
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response){
		donationService.multiplePhotoUpload(request, response);
		
	}
	
	@RequestMapping(value = "file_upload_form.do", method = RequestMethod.GET)
    public String file_upload_form(ModelMap modelMap) {
        return "file_upload_form";
    }
     
    @RequestMapping(value = "file_upload_save.do", method = RequestMethod.POST)
    public String file_upload_save(@RequestParam("uploadfile") MultipartFile uploadfile, ModelMap modelMap) {
        OutputStream out = null;
        PrintWriter printWriter = null;
        try {
            // 파일명 얻기
            String fileName = uploadfile.getOriginalFilename();
            // 파일의 바이트 정보 얻기
            byte[] bytes = uploadfile.getBytes();
            // 파일의 저장 경로 얻기
            String uploadPath = "/업로드폴더/" + fileName;
            // 파일 객체 생성
            File file = new File(uploadPath);
            // 상위 폴더 존재 여부 확인
            if (!file.getParentFile().exists()) {
                // 상위 폴더가 존재 하지 않는 경우 상위 폴더 생성
                file.getParentFile().mkdirs();
            }           
            // 파일 아웃풋 스트림 생성
            out = new FileOutputStream(file);
            // 파일 아웃풋 스트림에 파일의 바이트 쓰기
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "/file_upload_form";
    }
 



	
	/**
	* 작성이유 : 재능기부 신청서 수정
	* 
	* @author 은성민
	*/
	@RequestMapping("updateApplication.do")
	public String updateApplication(ApplicationPostVO apVO) {
		donationService.updateApplication(apVO);
		return null;
	}
}
