<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 문의 글 작성 -->
<script type="text/javascript">
$(document).ready(function(){
	if(${sessionScope.mvo.id == null}){
		alert("로그인 후 이용해 주세요!")
		location.href="${pageContext.request.contextPath}/member/loginForm.do"
	}
	$("#questionForm").submit(function(){
		alert("문의 글이 등록되었습니다. 답변은 마이페이지에서 확인할 수 있습니다.")
	});//click
}); //ready
</script>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">문의하기</h4>
</div>
<!-- /.Page Heading -->
<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-6 offset-lg-3 my-4">
			<form name="sentMessage" id="questionForm" action="${pageContext.request.contextPath}/board/addWebQuestion.do" method="post" novalidate>
				<div class="control-group form-group">
<!-- 					<div class="controls">
						<label>작성자</label>
						<input type="tel" class="form-control" id="name" required data-validation-required-message="Please enter your phone number.">
					</div> -->
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<input type="text" class="form-control" name="wqTitle" placeholder="제목">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<textarea rows="10" cols="100" class="form-control" name="wqContents" maxlength="999" style="resize:none" placeholder="내용"></textarea>
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="submit" class="btn btn-sub-2-gnt btn-block" id="sendMessageButton">문의하기</button>
			</form>
		</div>

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->