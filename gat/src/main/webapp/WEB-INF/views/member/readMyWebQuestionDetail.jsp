<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">내 문의 글 보기</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h3 class="my-3 px-3">${wqPostVO.wqTitle}</h3>
			<p class="border border-left-0 border-right-0 py-3 px-3">글 번호: ${wqPostVO.wqNo} &nbsp;&nbsp;&nbsp; 작성 시간: ${wqPostVO.wqRegdate}
			&nbsp;&nbsp;&nbsp; 처리 상태: ${wqPostVO.wqStatus} </p>
			<div class="content">
			<!--글내용-->
				<div class="jumbotron">
					${wqPostVO.wqContents}
				</div>
			</div>	
		</div>
		
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1">
			<div class="d-flex align-items-end">
					<a href="#" class="btn btn-sub-3-gnt mr-1" id="questionUpdateBtn">수정</a>
					<a href="#" class="btn btn-sub-4-gnt" id="questionDeleteBtn">삭제</a>
					<a href="${pageContext.request.contextPath }/member/readMyWebQuestionList.do?nowPage=1" class="btn btn-sub-2-gnt ml-auto mr-1">목록</a>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->