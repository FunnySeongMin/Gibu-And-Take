<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>    
<script type="text/javascript">
	$(document).ready(function(){
		
		$('.memberDelete').click(function(){
			var con_test = confirm("탈퇴하시겠습니까?");
			if(con_test == true){
				 alert("탈퇴되었습니다. 감사합니다.");
				 location.href="${pageContext.request.contextPath}/member/deleteMember.do";
				}
				else if(con_test == false){
				  return false;
				}
		});
	});
</script>
<!-- Page Heading -->
   <div class="page-heading bg-sub-3-gnt">
      <h4 class="py-5 text-center">마이페이지</h4>
   </div>
   
   <!-- /.Page Heading -->

   <!-- Page Content -->
   <div class="container my-5">
      <!-- row -->
      <div class="row">
         <div class="col-lg-6 offset-lg-3 mb-1">
            <div class="card-group">
               <div class="card">
                  <div class="card-header">
                     나의 정보
                  </div>
                  <div class="card-body">
                     <div class="card-text">
                        <div class="col-6"></div>
                        <p class="small-txt">회원이름 : ${sessionScope.mvo.name}</p>
                        <p class="small-txt">이메일 : ${sessionScope.mvo.email}</p>
                        <p class="small-txt">주소 : ${sessionScope.mvo.address}</p>
                        <p class="small-txt">회원등급 : ${sessionScope.mvo.memberGradeVO.mgradeName}</p>
                     </div>
                     <a href="${pageContext.request.contextPath }/member/updateForm.do" class="btn btn-sub-2-gnt btn-sm">수정</a>
                  </div>
               </div>
               <div class="card">
                  <div class="card-header">
                     	비밀번호 변경
                  </div>
                  <div class="card-body">
        
                     <div class="card-text"></div>
                     <a href="${pageContext.request.contextPath }/member/modifyPassword.do" class="btn btn-sub-2-gnt btn-sm">변경</a>
                  </div>
                   <div class="card-header" id="memberDelet">
                     	회원 탈퇴
                  </div>
                  <div class="card-body">
                     
                     <div class="card-text"></div>
                     <!-- <a href="#" class="btn btn-sub-2-gnt btn-sm memberDelet">탈퇴</a> -->
                     <button type="submit" class="btn btn-sub-2-gnt btn-sm memberDelete">탈퇴</button>
                  </div>
               </div>
            </div>
         </div>

      </div>
      <!-- /.row -->
      <!-- row -->
      <div class="row">
         <div class="col-lg-6 offset-lg-3">
            <div class="card-group">
               <div class="card">
                  <div class="card-header">마일리지</div>
                  <div class="card-body">
                     <div class="card-text">
                        <p>보유 마일리지 : ${sessionScope.mvo.mileage}</p>
                     </div>
                     <a href="${pageContext.request.contextPath}/member/addMileage.do" class="btn btn-sub-2-gnt btn-sm mr-1">충전/환전/조회</a>
                  </div>
               </div>
               <div class="card">
                  <div class="card-header">나의 활동</div>
                  <div class="card-body">
                     <div class="card-text">
                        <p>나의 기부활동 참여 ${appCount}건</p>
                     </div>
                     <a href="${pageContext.request.contextPath}/member/readMyActivityList.do?nowPage=1" class="btn btn-sub-2-gnt btn-sm">활동목록</a>
                     <a href="${pageContext.request.contextPath}/member/readMyReviewPostList.do?nowPage=1" class="btn btn-sub-2-gnt btn-sm">후기내역</a>
                     <a href="${pageContext.request.contextPath}/member/readMyWebQuestionList.do?nowPage=1" class="btn btn-sub-2-gnt btn-sm">문의</a>
                  </div>
               </div>
            </div>
         </div>

      </div>
      <!-- /.row -->

   </div>
   <!-- /.container -->

    <hr>