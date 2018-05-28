<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#deleteBtn").click(function() {
		var result = confirm("후기를 삭제하시겠습니까?")
		if(result)
			location.href="${pageContext.request.contextPath}/member/deleteMyReview.do?rpNo=${reviewPostVO.rpNo}";
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
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h4 class="my-3 px-3">#${reviewPostVO.rpNo} 글 제목 : ${reviewPostVO.rpTitle}</h4>
			<p class="border border-left-0 border-right-0 py-3 px-3">
			<span>참여 기부활동 : ${reviewPostVO.dpVO.dpTitle} &nbsp; 	&#5;</span>
			&nbsp;나의 평점 : ${reviewPostVO.rpRate} 점 &nbsp; 	&#5;
			작성일자 : ${reviewPostVO.rpRegdate}</p>
			<!--글내용-->
				<div class="jumbotron">
					${reviewPostVO.rpContents}
				</div>
			</div>
			
		</div>
		
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1">
			<div class="d-flex align-items-end">
				<a href="javascript:history.back()" class="btn btn-sub-2-gnt ml-auto mr-1 " id="#" >목록</a>
				<a href="#" class="btn btn-sub-3-gnt mr-1" id="#">수정</a>
				<a href="#" class="btn btn-sub-4-gnt" id="deleteBtn">삭제</a>
			</div>
		</div>
	</div>
	<!-- /.row -->
 
</div>
<!-- /.container -->