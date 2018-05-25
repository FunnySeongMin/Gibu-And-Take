<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <script type="text/javascript">
	alert(${apListVO.appPb.nowPage});
</script> -->
<!-- Page Heading -->
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">신청서</h4>
</div>
<!-- /.Page Heading -->
<!-- Page Content -->
<div class="container">
	<div class="col-10 offset-lg-1">
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover unReceivedAppList">
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일자</td>
						<td>승인여부</td>
					</tr>
				</thead>
				<tbody>
				<c:set value="${apListVO.appPostVO }" var="appPostVO"/>
					<c:forEach items="${appPostVO }" var="apPostVO">
						<tr>
							<td>${apPostVO.appNo }</td>
							<td><a href="${pageContext.request.contextPath }/readUnReceivedApplicationDetail.do?apno=${apPostVO.appNo}">${apPostVO.appTitle }</a></td>
							<td>${apPostVO.memberVO.name }</td>
							<td>${apPostVO.appRegdate }</td>
							<td>${apPostVO.appStatus }</td>
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
		<c:if test="${apListVO.appPb.previousPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath }/readUnReceivedApplicationList.do?nowPage=${apListVO.appPb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">
						Previous
					</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="page" begin="${apListVO.appPb.startPageOfPageGroup}" end="${apListVO.appPb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${apListVO.appPb.nowPage!=page}">
					<li class="page-item">
						<a class="page-link"  href="${pageContext.request.contextPath }/readUnReceivedApplicationList.do?nowPage=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link"  href="#">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${apListVO.appPb.nextPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath }/readUnReceivedApplicationList.do?nowPage=${apListVO.appPb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>

</div>
<!-- /.container -->