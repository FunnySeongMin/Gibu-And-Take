<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <script type="text/javascript">
	alert(${apListVO.appPb.nowPage});
</script> -->
<!-- Page Heading -->
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">답변없는 문의글</h4>
</div>
<!-- /.Page Heading -->
<!-- Page Content -->
<div class="container">
	<div class="col-10 offset-lg-1">
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover webQuestion">
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일자</td>
					</tr>
				</thead>
				<tbody>
				<c:set value="${wqListVO.wqPostVO }" var="wqPostVO"/>
					<c:forEach items="${wqPostVO }" var="wqPostVO">
						<tr class="webQuestionRe" >
							<td>${wqPostVO.wqNo }</td>
							<c:choose>
								<c:when test="${!wqPostVO.answer }">
									<td><a href="${pageContext.request.contextPath}/readUnReceivedWebQuestionDetail.do?wqno=${wqPostVO.wqNo}" class="pl-4"><span style="color:#f35b56">⇒ Re: </span>${wqPostVO.wqTitle }</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="${pageContext.request.contextPath}/readUnReceivedWebQuestionDetail.do?wqno=${wqPostVO.wqNo}">${wqPostVO.wqTitle }</a></td>
								</c:otherwise>
							</c:choose>
							<td>${wqPostVO.memberVO.name }</td>
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
		<c:if test="${wqListVO.wqPb.previousPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath }/readUnReceivedWebQuestionList.do?nowPage=${wqListVO.wqPb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">
						Previous
					</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="page" begin="${wqListVO.wqPb.startPageOfPageGroup}" end="${wqListVO.wqPb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${wqListVO.wqPb.nowPage!=page}">
					<li class="page-item">
						<a class="page-link"  href="${pageContext.request.contextPath }/readUnReceivedWebQuestionList.do?nowPage=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link"  href="#">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${wqListVO.wqPb.nextPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath }/readUnReceivedWebQuestionList.do?nowPage=${wqListVO.wqPb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>

</div>
<!-- /.container -->