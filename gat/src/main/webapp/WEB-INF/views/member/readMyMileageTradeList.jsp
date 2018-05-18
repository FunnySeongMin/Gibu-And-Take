<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- 마일리지 내역  -->
 <div class="container my-5">
		<div class="row">
			<div class="col-lg-3">
				<div class="list-group">
					<a href="${pageContext.request.contextPath }/member/addMileage.do" class="list-group-item">마일리지 충전</a>
					<a href="${pageContext.request.contextPath }/member/exchangeMileage.do" class="list-group-item">마일리지 환전</a>
					<a href="${pageContext.request.contextPath }/member/readMyMileageTradeList.do?nowPage=1" class="list-group-item active">마일리지 내역</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->
			<div class="col-lg-9">
				<h4 class="mb-4">마일리지 내역</h4>
				<table class="table table-hover">
					<thead>
						<tr>
   							 <th>거래 일시</th> <th>거래 분류</th> <th>거래량</th>
 						 </tr>
  					</thead>
  					<tbody>
  						<c:forEach items="${listVO.mtVO}" var="list">
   					 <tr>
  						<td>${list.mtRegdate}</td>
  						<c:choose>
  						<c:when test="${list.mugVO.mugNo==1}">
  						<td class="text-primary">${list.mugVO.mugName}</td>
  						<td class="text-primary">+${list.mtVolume}</td>
  						</c:when>
  						<c:when test="${list.mugVO.mugNo==2 || list.mugVO.mugNo==3}">
  						<td class="text-danger">${list.mugVO.mugName}</td>
  						<td class="text-danger">-${list.mtVolume}</td>
  						</c:when>
  						<c:otherwise>
  						</c:otherwise>
  						</c:choose>
   					 </tr>
  						</c:forEach>
					</tbody>
				</table>
				
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
			<!-- /.col-lg-9 -->
		</div>
	</div>
	<!-- /.container -->