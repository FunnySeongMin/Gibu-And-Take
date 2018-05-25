<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function givePoint(id,mileage,tdNo){
		var flag=confirm(id+"님에게 "+mileage+"포인트를 지급하시겠습니까?");
		if(flag){
			location.href="${pageContext.request.contextPath}/givePoint.do?id="+id+"&mileage="+mileage+"&tdNo="+tdNo;
		}else{
			return false;
		}
	}
</script>
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">포인트 지급관리</h4>
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
						<td>참여내용</td>
						<td>사용 마일리지</td>
						<td>포인트 관리</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tdListVO.tdpVO }" var="tdpVO">
							<tr>
								<td>${tdpVO.memberVO.id }</td>
								<td>${tdpVO.memberVO.name }</td>
								<td>${tdpVO.donationPostVO.dpTitle }</td>
								<td>${tdpVO.tdMileage }</td>
								<td>
									<input type="button" value="포인트 지급" 
									onclick="return givePoint('${tdpVO.donationPostVO.memberVO.id}','${tdpVO.tdMileage }',${tdpVO.tdNo })"
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
		<c:if test="${tdListVO.tdpPb.previousPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/readTradePoint.do?nowPage=${tdListVO.tdpPb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">
						Previous
					</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="page" begin="${tdListVO.tdpPb.startPageOfPageGroup}" end="${tdListVO.tdpPb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${mListVO.mPb.nowPage!=page}">
					<li class="page-item">
						<a class="page-link"  href="${pageContext.request.contextPath}/readTradePoint.do?nowPage=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link"  href="#">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${tdListVO.tdpPb.nextPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/readTradePoint.do?nowPage=${tdListVO.tdpPb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>

</div>