<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">�� ����</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h3 class="my-3 px-3">${apVO.appTitle }</h3>
			<p class="border border-left-0 border-right-0 py-3 px-3">${apVO.memberVO.name }, ${apVO.appRegdate }</p>
			<div class="content">
			<!--�۳���-->
				<div class="jumbotron">
					${apVO.appContents }
				</div>
			</div>
			
		</div>
		
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1">
			<div class="d-flex align-items-end">
				<a href="${pageContext.request.contextPath }/readUnReceivedApplicationList.do?nowPage=1" class="btn btn-sub-2-gnt ml-auto mr-1 " id="#" >���</a>
				<c:choose>
					<c:when test="${sessionScope.mvo.id==apVO.memberVO.id }">
						<a href="#" class="btn btn-sub-3-gnt mr-1" id="#">����</a>
						<a href="#" class="btn btn-sub-4-gnt" id="#">����</a>
					</c:when>
					<c:when test="${sessionScope.mvo.memberGroupVO.mgroupNo=='4'}">
						<a href="updateUnReceivedApplication.do?apno=${apVO.appNo }&command=����" class="btn btn-sub-3-gnt mr-1" id="#">����</a>
						<a href="updateUnReceivedApplication.do?apno=${apVO.appNo }&command=����" class="btn btn-sub-4-gnt" id="#">����</a>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->