<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Heading -->
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">나의 후기</h4>
</div>
<!-- /.Page Heading -->
<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일자</td>
					</tr>
				</thead>
					<tbody>
					<c:forEach var="pvo" items="${requestScope.rpListVO.list}" >
						<tr>
							<td>${pvo.rpNo}</td>
							<td><a href="${pageContext.request.contextPath}/member/readMyReviewDetail.do?rpNo=${pvo.rpNo}">${pvo.rpTitle}</a></td>
							<td>${sessionScope.mvo.name}</td>
							<td>${pvo.rpRegdate}</td>
						</tr>
					</c:forEach>
					</tbody>
			</table>
		</div>
	</div>
	<!-- /.row -->	
	
	<hr>
	
	<!-- Pagination -->
	<c:set var="pb" value="${requestScope.rpListVO.rpPb}"></c:set>
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