<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>    
<script type="text/javascript">
</script>
<!-- Page Heading -->
   <div class="page-heading bg-sub-3-gnt">
      <h4 class="py-5 text-center">관리자 페이지</h4>
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
                  	처리되지 않은 신청서
                  </div>
                  <div class="card-body">
                     <div class="card-text">
                        <div class="col-6"></div>
                        <div class="text-center"><span><b style="font-size:40px">
                        	${appCount }
                        </b></span>&nbsp;건</div>
                     	<br>
                     </div>
                     <div class="text-center"><a href="${pageContext.request.contextPath }/readUnReceivedApplicationList.do?nowPage=1" class="btn btn-sub-2-gnt btn-sm">목록보기</a></div>
                  </div>
               </div>
               <div class="card">
                  <div class="card-header">
                  	답변없는 문의
                  </div>
                  <div class="card-body">
                     <div class="card-text">
                        <div class="col-6"></div>
                        <div class="text-center"><span><b style="font-size:40px">
                        	${qCount }
                        </b></span>&nbsp;건</div>
                     	<br>
                     </div>
                     <div class="text-center"><a href="${pageContext.request.contextPath }/readWebQuestionList.do?nowPage=1" class="btn btn-sub-2-gnt btn-sm">목록보기</a></div>
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
                  <div class="card-header">회원 관리</div>
                  <div class="card-body">
                     <div class="card-text text-center">
                        <p>총 회원 수 ${memberCount} 명</p>
                     </div>
                     <div class="text-center"><a href="${pageContext.request.contextPath}/member/mileagePage.do" class="btn btn-sub-2-gnt btn-sm mr-1">회원관리</a></div>
                  </div>
               </div>
               <div class="card">
                  <div class="card-header">포인트 지급</div>
                  <div class="card-body">
                     <div class="card-text text-center">
                        <p>지급 예정  ${tradePointCount}건</p>
                     </div>
                     <div class="text-center"><a href="" class="btn btn-sub-2-gnt btn-sm">바로가기</a></div>
                  </div>
               </div>
            </div>
         </div>

      </div>
      <!-- /.row -->

   </div>
   <!-- /.container -->

    <hr>