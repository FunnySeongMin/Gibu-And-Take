<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <script type="text/javascript">
	alert(${apListVO.appPb.nowPage});
</script> -->
<!-- Page Heading -->
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">내 문의 목록</h4>
</div>
<!-- /.Page Heading -->
<!-- Page Content -->
<div class="container">
	<div class="col-10 offset-lg-1">
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>상태</td>
						<td>작성일자</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${wqListVO.wqPostVO}" var="wqPostVO">
						<tr>
							<td>${wqPostVO.wqNo}</td>
							<td><a href="${pageContext.request.contextPath}/member/readMyWebQuestionDetail.do?wqNo=${wqPostVO.wqNo}">${wqPostVO.wqTitle}</a></td>
							<td>${wqPostVO.wqStatus}</td>
							<td>${wqPostVO.wqRegdate }</td>
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
	<c:set var="pb" value="${wqListVO.wqPb}"></c:set>
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/member/readMyWebQuestionList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">
						Previous
					</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="page"  begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=page}">
					<li class="page-item">
						<a class="page-link"  href="${pageContext.request.contextPath}/member/readMyWebQuestionList.do?nowPage=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item active">
						<a class="page-link"  href="#">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pb.nextPageGroup}">
<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/member/readMyWebQuestionList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
						</a>
					</li>
		</c:if>
	</ul>

</div>
<!-- /.container -->