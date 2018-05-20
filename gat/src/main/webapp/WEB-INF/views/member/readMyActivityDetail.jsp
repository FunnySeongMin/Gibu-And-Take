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
				<a href="${pageContext.request.contextPath }/member/readMyActivityList.do" class="list-group-item active">재능기부 참여내역</a>
				<a href="${pageContext.request.contextPath }/member/readMyApplicationList.do" class="list-group-item">재능기부 신청내역</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<h4 class="mb-4">재능기부 참여내역</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>기부 프로젝트명</th>
						<th>참여일</th>
					</tr>
				</thead>
				<tbody>						
					<tr>
						<td>3</td>
						<td><a href="#">청소왕 황마의 청소 A to Z</a></td>
						<td>황명아</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="#">서정우의 코딩스쿨</a></td>
						<td>서정우</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">오늘뭐먹지? 이윤희의 유니짜장</a></td>
						<td>이윤희</td>
					</tr>
				</tbody>
			</table>

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
