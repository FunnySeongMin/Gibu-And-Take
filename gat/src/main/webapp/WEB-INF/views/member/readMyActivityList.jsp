<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<a href="${pageContext.request.contextPath }/member/readMyApplicationList.do?nowPage=1" class="list-group-item">재능기부 신청내역</a>
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
						<th>참여 마일리지</th>
						<th>참여일</th>
					</tr>
				</thead>
				<tbody>			
					<c:forEach var="tvo" items="${requestScope.tdListVO.tdpVO}">	
					<tr>
						<td>${tvo.tdNo}</td>
						<td>${tvo.donationPostVO.dpTitle}</td>
						<td>${tvo.tdMileage}</td>
						<td>${tvo.tdRegdate}</td>
					</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	
	<!-- Pagination -->
	<c:set var="pb" value="${requestScope.tdListVO.tdpPb}"></c:set>
	<ul class="pagination justify-content-center mt-5">
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/member/readMyReviewPostList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/member/readMyReviewPostList.do?nowPage=${i}">${i}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="#">${i}</a>
					</li>
				</c:otherwise>
			</c:choose>
			&nbsp;
		</c:forEach>
		<c:if test="${pb.nextPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/member/readMyReviewPostList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>

</div>
<!-- /.container -->
