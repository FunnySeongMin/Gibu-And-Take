<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script type="text/javascript">
$(document).ready(function(){
	if(${sessionScope.mvo.id == null}){
		alert("�α��� �� �̿��� �ּ���!")
		location.href="${pageContext.request.contextPath}/member/loginForm.do"
	}
	$("#reviewForm").submit(function(){
		alert("���� ���� �����Ǿ����ϴ�.")
	});//click
}); //ready
</script>
    
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">�� ����</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<form id="reviewForm" action="${pageContext.request.contextPath}/member/updateMyReview.do" method="post" novalidate>
	<input type="hidden" name="rpNo" value="${rPostVO.rpNo}">
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0 updateMyReviewP">
			<p class="my-3 px-3">#${rPostVO.rpNo} 
			�� ���� : </p>
			<input type="text" class="form-control rpTitleInput" name="rpTitle" placeholder="����" value="${rPostVO.rpTitle}">
			<p class="border border-left-0 border-right-0 py-3 px-3">
			<span>���� ���Ȱ�� : ${rPostVO.dpVO.dpTitle} &nbsp; 	&#5;</span>
			&nbsp;���� ���� : ${rPostVO.rpRate} �� &nbsp; 	&#5;
			�ۼ����� : ${rPostVO.rpRegdate}</p>
			<!--�۳���-->
				<div class="jumbotron">
					<textarea rows="10" cols="100" class="form-control" name="rpContents" maxlength="999" style="resize:none" placeholder="����">${rPostVO.rpContents}</textarea>
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-sub-2-gnt btn-block col-10" id="sendMessageButton">�����ϱ�</button>
	</form>
	</div>

	<!-- /.row -->

<!-- /.container -->