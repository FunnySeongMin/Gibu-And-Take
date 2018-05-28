<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script type="text/javascript">
$(document).ready(function(){
	if(${sessionScope.mvo.id == null}){
		alert("로그인 후 이용해 주세요!")
		location.href="${pageContext.request.contextPath}/member/loginForm.do"
	}
	$("#reviewForm").submit(function(){
		alert("문의 글이 수정되었습니다.")
	});//click
}); //ready
</script>
    
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">글 보기</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<form id="reviewForm" action="${pageContext.request.contextPath}/member/updateMyReview.do" method="post" novalidate>
	<input type="hidden" name="rpNo" value="${rPostVO.rpNo}">
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0 updateMyReviewP">
			<p class="my-3 px-3">#${rPostVO.rpNo} 
			글 제목 : </p>
			<input type="text" class="form-control rpTitleInput" name="rpTitle" placeholder="제목" value="${rPostVO.rpTitle}">
			<p class="border border-left-0 border-right-0 py-3 px-3">
			<span>참여 기부활동 : ${rPostVO.dpVO.dpTitle} &nbsp; 	&#5;</span>
			&nbsp;나의 평점 : ${rPostVO.rpRate} 점 &nbsp; 	&#5;
			작성일자 : ${rPostVO.rpRegdate}</p>
			<!--글내용-->
				<div class="jumbotron">
					<textarea rows="10" cols="100" class="form-control" name="rpContents" maxlength="999" style="resize:none" placeholder="내용">${rPostVO.rpContents}</textarea>
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-sub-2-gnt btn-block col-10" id="sendMessageButton">수정하기</button>
	</form>
	</div>

	<!-- /.row -->

<!-- /.container -->