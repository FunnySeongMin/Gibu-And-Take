<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<table class="table table-hover myWebQuestionList">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
				<c:set value="${wqListVO.wqPostVO }" var="wqPostVO"/>
					<c:forEach items="${wqPostVO }" var="wqPostVO" varStatus="count">
						<tr>
							<td>${wqPostVO.wqNo}</td>
							<c:choose>
								<c:when test="${!wqPostVO.answer}">
									<td><a href="${pageContext.request.contextPath}/member/readMyWebQuestionDetail.do?wqNo=${wqPostVO.wqNo}" class="pl-4"><span style="color:#f35b56">⇒ Re: </span>${wqPostVO.wqTitle}</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="${pageContext.request.contextPath}/member/readMyWebQuestionDetail.do?wqNo=${wqPostVO.wqNo}">${wqPostVO.wqTitle }</a></td>
								</c:otherwise>
							</c:choose>
							<td>${wqPostVO.wqRegdate}</td>
							<c:choose>
							<c:when test="${wqPostVO.wqStatus=='처리중'}">
							<td><span class="label label-warning">${wqPostVO.wqStatus}</span></td>
							</c:when>
							<c:otherwise>
							<td><span class="label label-danger">${wqPostVO.wqStatus}</span></td>
							</c:otherwise>
							</c:choose>
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