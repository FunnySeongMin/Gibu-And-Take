<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header-top -->
<div class="header-top">
	<div class="container">
		<ul class="nav justify-content-end">
		<c:choose>
			<c:when test="${sessionScope.mvo!=null}">
				<li class="nav-item"><a class="nav-link" href="#">${sessionScope.mvo.name} 님</a></li>
				<c:if test="${sessionScope.mvo.memberGroupVO.mgroupNo!='4' }">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/myPage.do">마이페이지</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/logout.do">Logout</a></li>
				<c:if test="${sessionScope.mvo.memberGroupVO.mgroupNo=='4' }">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/adminPageData.do">관리자 페이지</a></li>
				</c:if>
			</c:when>
			<c:otherwise>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/loginForm.do">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/registerMemberForm.do">Register</a></li>
			</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="${pageContext.request.contextPath }/"><img src="${pageContext.request.contextPath }/resources/img/logo.png" alt="Gibu and Take"></a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath }/donation/listDonation.do">기부</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">테이킹</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath }/board/listBoard.do">커뮤니티</a>
        </li>
      
      </ul>
    </div>
  </div>
</nav>