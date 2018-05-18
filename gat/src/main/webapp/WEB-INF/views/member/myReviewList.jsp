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
					<c:forEach var="pvo" items="${requestScope.rpListVO.list}">
						<tr>
							<td>${pvo.rpNo}</td>
							<td><a href="#">${pvo.rpTitle}</a></td>
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
	<ul class="pagination justify-content-center mt-5">
		<c:set var="pb" value="${requestScope.rpListVO.pagingBean}"></c:set>
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
			<a class="page-link" href="${pageContext.request.contextPath}/readMyReviewPostList.do?pageNo=${pb.startPageOfPageGroup-1}" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		</c:if>

		<li class="page-item">
			<a class="page-link" href="#">1</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">2</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">3</a>
		</li>
		<c:if test="${pb.nextPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/readMyReviewPostList.do?pageNo=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</c:if>
		
		
	</ul>

</div>
<!-- /.container -->