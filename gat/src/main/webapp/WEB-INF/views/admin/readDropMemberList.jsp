<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function restoreMember(id){
		var flag=confirm(id+"님을 복구 시키시겠습니까?");
		if(flag){
			location.href="${pageContext.request.contextPath}/restoreMember.do?id="+id;
		}else{
			return false;
		}
	}
</script>
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">탈퇴회원관리</h4>
</div>
<div class="container">
	<div class="col-10 offset-lg-1">
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>아이디</td>
						<td>이름</td>
						<td>주소</td>
						<td>이메일</td>
						<td>보유 마일리지</td>
						<td>총 사용 마일리지</td>
						<td>회원분류</td>
						<td>회원등급</td>
						<td>관리</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mListVO.mlist }" var="mlist">
							<tr>
								<c:set value="${mlist.id }" var="id"></c:set>
								<td>${id }</td>
								<td>${mlist.name }</td>
								<td>${mlist.address }</td>
								<td>${mlist.email }</td>
								<td>${mlist.mileage }</td>
								<td>${mlist.totalUseMileage }</td>
								<td>${mlist.memberGroupVO.mgroupName }</td>
								<td>${mlist.memberGradeVO.mgradeName }</td>
								<td>
									<input type="button" value="복구" onclick="return restoreMember('${id}')" 
									class="btn btn-sub-2-gnt btn-block">
								</td> 
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<hr>
	
	<ul class="pagination justify-content-center mt-5">
		<c:if test="${mListVO.mPb.previousPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/readMemberList.do?nowPage=${mListVO.mPb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">
						Previous
					</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="page" begin="${mListVO.mPb.startPageOfPageGroup}" end="${mListVO.mPb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${mListVO.mPb.nowPage!=page}">
					<li class="page-item">
						<a class="page-link"  href="${pageContext.request.contextPath}/readMemberList.do?nowPage=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link"  href="#">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${mListVO.mPb.nextPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/readMemberList.do?nowPage=${mListVO.mPb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>

</div>