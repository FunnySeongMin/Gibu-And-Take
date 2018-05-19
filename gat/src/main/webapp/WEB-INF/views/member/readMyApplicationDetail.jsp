<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">마이페이지</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
   <div class="container my-5">

	<div class="row">
		<div class="col-lg-3">
			<div class="list-group">
				<a href="${pageContext.request.contextPath }/member/readMyActivityList.do" class="list-group-item">재능기부 참여내역</a>
				<a href="${pageContext.request.contextPath }/member/readMyApplicationList.do" class="list-group-item active">재능기부 신청내역</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<h4 class="mb-4">재능기부 신청내역</h4>
			<h3 class="my-3 px-3">글제목</h3>
			<p class="border border-left-0 border-right-0 py-3 px-3 mb-2">작성자, 신청일자</p>
			<p class="border border-left-0 border-right-0 py-3 px-3 point-txt-gnt">승인여부</p>
			<div class="content">
			<!--글내용-->
				<div class="jumbotron">
					글내용
				</div>
			</div>
			<div class="d-flex align-items-end">
				<a href="listQna.html" class="btn btn-sub-2-gnt ml-auto mr-1 " id="#" >목록</a>
				<a href="writeQnaAnswer.html" class="btn btn-sub-3-gnt mr-1" id="#">답변</a>
			</div>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	
	<!-- Pagination -->
	<ul class="pagination justify-content-center mt-5">
		<li class="page-item">
			<a class="page-link" href="#" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
				<span class="sr-only">Previous</span>
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">1</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">2</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">3</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
				<span class="sr-only">Next</span>
			</a>
		</li>
	</ul>

</div>
<!-- /.container -->
