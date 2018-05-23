package org.kosta.gat.model.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.gat.model.vo.post.application.ApplicationPostVO;
import org.kosta.gat.model.vo.post.application.PresentVO;
import org.kosta.gat.model.vo.post.donation.DonationPostListVO;
import org.kosta.gat.model.vo.post.donation.DonationPostPagingBean;
import org.kosta.gat.model.vo.post.donation.DonationPostVO;
import org.kosta.gat.model.vo.post.review.ReviewPostListVO;
import org.kosta.gat.model.vo.post.review.ReviewPostPagingBean;
import org.kosta.gat.model.vo.post.review.ReviewPostVO;
import org.kosta.gat.model.vo.post.takedonation.TakeDonationPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

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
	public List<TakeDonationPostVO> readDonationCheerUpMessageList(String dpno) {
		return template.selectList("donation.readDonationCheerUpMessageList",dpno);
	}

	@Override
	public ReviewPostListVO readDonationReviewList(String dpno,int nowPage) {
		ReviewPostPagingBean rpPb=null;
		
		//해당 후기글의 총 게시글 수
		int totalDonationReviewCount=template.selectOne("donation.totalDonationReviewCount", dpno);
		System.out.println("DonationDAOImpl : "+totalDonationReviewCount);
		if(nowPage==0) {
			rpPb=new ReviewPostPagingBean(totalDonationReviewCount);
		}else {
			rpPb=new ReviewPostPagingBean(totalDonationReviewCount, nowPage);
		}
		rpPb.setId(dpno);
		List<ReviewPostVO> rpList=  template.selectList("donation.readDonationReviewList", rpPb);
		ReviewPostListVO rpListVO=new ReviewPostListVO(rpList, rpPb);

		return rpListVO;
	}
	/*
	@Override
	public List<ReviewPostVO> readDonationReviewList(String dpno) {
		return template.selectList("donation.readDonationReviewList",dpno);
	}*/
	
	@Override
	public ReviewPostVO readReviewDetail(String rpno) {
		return template.selectOne("donation.readReviewDetail", rpno);
	}
	
	//신청서 작성
	@Override
	public String addApplication(ApplicationPostVO apVO) {
		System.out.println("DAO :"+apVO);
		template.insert("donation.addApplication", apVO);
		System.out.println("시퀀스 넘버:"+apVO.getAppNo());
		return apVO.getAppNo();
	}

	@Override
	public void updateApplication(ApplicationPostVO apVO) {
		template.update("donation.updateApplication", apVO);
	}

	@Override
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("멀티");
	    try {
	         //파일정보
	         String sFileInfo = "";
	         //파일명을 받는다 - 일반 원본파일명
	         String filename = request.getHeader("file-name");
	         //파일 확장자
	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
	         //확장자를소문자로 변경
	         filename_ext = filename_ext.toLowerCase();
	         //파일 기본경로
	         String dftFilePath = request.getSession().getServletContext().getRealPath("/");
	         //파일 기본경로 _ 상세경로 - 시연경로
	         String filePath = dftFilePath + "resources" + File.separator + "photo_upload" + File.separator;
	         // 테스트 경로
	         //String filePath = "C:\\java-kosta\\framework\\workspace2\\gat\\src\\main\\webapp\\resources\\img" + File.separator;
	         File file = new File(filePath);
	         if(!file.exists()) {
	            file.mkdirs();
	         }
	         String realFileNm = "";
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	         String today= formatter.format(new java.util.Date());
	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
	         String rlFileNm = filePath + realFileNm;
	         ///////////////// 서버에 파일쓰기 /////////////////
	         InputStream is = request.getInputStream();
	         OutputStream os=new FileOutputStream(rlFileNm);
	         int numRead;
	         byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	         while((numRead = is.read(b,0,b.length)) != -1){
	            os.write(b,0,numRead);
	         }
	         if(is != null) {
	            is.close();
	         }
	         os.flush();
	         os.close();
	         ///////////////// 서버에 파일쓰기 /////////////////
	         // 정보 출력
	         sFileInfo += "&bNewLine=true";
	         // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
	         sFileInfo += "&sFileName="+ filename;
	         //시연경로
	         sFileInfo += "&sFileURL="+"/gat/resources/photo_upload/"+realFileNm;
	         //테스트파일경로
	         //sFileInfo += "&sFileURL="+"./resources/img/"+realFileNm;	         
	         PrintWriter print = response.getWriter();
	         print.print(sFileInfo);
	         print.flush();
	         print.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public String photoUpload(HttpServletRequest request, PhotoVo vo) {
		System.out.println("단일");
	    String callback = vo.getCallback();
	    String callback_func = vo.getCallback_func();
	    String file_result = "";
	    try {
	        if(vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null && !vo.getFiledata().getOriginalFilename().equals("")){
	            //파일이 존재하면
	            String original_name = vo.getFiledata().getOriginalFilename();
	            String ext = original_name.substring(original_name.lastIndexOf(".")+1);
	            System.out.println("1"+original_name+" / " + ext);
	            //파일 기본경로
	            String defaultPath = request.getSession().getServletContext().getRealPath("/");
	            System.out.println("2"+defaultPath);
	            //파일 기본경로 _ 상세경로
	            String path = defaultPath + "resources" + File.separator + "photo_upload" + File.separator;    
	            System.out.println("3"+defaultPath);
	            File file = new File(path);
	            System.out.println("path:"+path);
	            //디렉토리 존재하지 않을경우 디렉토리 생성
	            if(!file.exists()) {
	                file.mkdirs();
	            }
	            //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
	            String realname = UUID.randomUUID().toString() + "." + ext;
	        ///////////////// 서버에 파일쓰기 /////////////////
	            vo.getFiledata().transferTo(new File(path+realname));
	            file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/resources/photo_upload/"+realname;
	        } else {
	            file_result += "&errstr=error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:" + callback + "?callback_func="+callback_func+file_result;
		
	}

	@Override
	public String file_upload_save(MultipartFile uploadfile, ModelMap modelMap) {
		System.out.println("파일있음");
        OutputStream out = null;
        PrintWriter printWriter = null;
        String loadPath = null;
        try {
            // 파일명 얻기
            String fileName = uploadfile.getOriginalFilename();
            
            
            // 파일의 바이트 정보 얻기
            byte[] bytes = uploadfile.getBytes();
            // 파일의 저장 경로 얻기
            String uploadPath = "/java-kosta/was/spring-tomcat/webapps/gat/resources/photo_upload/" + fileName;
            loadPath = "/gat/resources/photo_upload/" + fileName;
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
        return loadPath;
	}

	@Override
	public void addPresent(ArrayList<PresentVO> list) {
		
		for(int i=0; i<list.size(); i++) {
			//System.out.println(list.get(i));
			template.insert("donation.addPresent", list.get(i));
		}
	}
	//일반 재능기부 게시판 view 페이지
	@Override
	public List<Map<String, Object>> DonationListView(DonationPostPagingBean dpPb) {
		/*return template.selectList("donation.DonationListView", dpPb);*/
		return template.selectList("donation.DonationListView2");
	}
	//스크롤 페이징 재능기부 게시판
	@Override
	public List<Map<String, Object>> DonationListView2() {
		/*return template.selectList("donation.DonationListView", dpPb);*/
		return template.selectList("donation.DonationListView2");
	}

	@Override
	public List<Map<String, Object>> DonationListRank() {
		return template.selectList("donation.DonationListRank");
	}

	/**
	 * 해당 재능기부 모금 마일리지, 총 재능기부 참여자 수 update
	 * 작성이유 : 회원이 재능기부 참여 한 후  회원이 사용한 마일리지 액수만큼 모금 마일리지에 누적
	 * 		 : 총 재능기부 참여자 수 누적
	 * @author 조민경
	 */
	@Override
	public void updateDonationMileageAndTotalEntry(TakeDonationPostVO tdVO) {
		template.update("donation.updateDonationMileage",tdVO);
		
	}
}