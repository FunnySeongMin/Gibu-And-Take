<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">문의글 답변수정</h4>
</div>
<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-lg-12 my-4">
			<form action="${pageContext.request.contextPath}/updateWebQuestionAnswer.do" method="post" name="sentMessage" id="contactForm" novalidate>
				<div class="control-group form-group">
					<div class="controls">
						<label>작성자</label>&nbsp;
						<input type="text" value="${sessionScope.mvo.name }" readonly="readonly"><br>
						<label>제목</label>&nbsp;
						<input type="text" name="wqTitle" value="${wqVO.wqTitle }">
						<input type="hidden" name="wqNo" value="${wqno }">
					</div>
				</div>

				<div class="control-group form-group">
					<!-- 스마트 에디터 -->
					<div class="controls">
						<textarea name="wqContents" id="appContents" rows="10" cols="100"
							style="width:636px; height:412px;">${wqVO.wqContents }</textarea>
						<!-- <textarea rows="10" cols="100" class="form-control" id="#" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="문의내용"></textarea> -->
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<input type="submit" id="savebutton"
					class="btn btn-sub-2-gnt btn-block" value="작성완료">
			</form>
		</div>

	</div>
	<!-- /.row -->
<img src="" style="width:100%;height:auto">
</div>
<!-- /.container -->


