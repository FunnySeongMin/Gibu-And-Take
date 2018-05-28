<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">신청서 거절</h4>
</div>
<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-lg-12 my-4">
			<form action="${pageContext.request.contextPath }/addApplicationAnswer.do" method="post" name="sentMessage" id="contactForm" novalidate>
				<div class="control-group form-group col-10 offset-lg-1">
					<div class="controls">
						<div class="writeAnswerLabel01">
						<label>작성자 : </label>&nbsp;
						<input type="text" value="${sessionScope.mvo.name}" readonly="readonly"><br>
						</div>
						<div class="writeAnswerLabel02">
						<label>제목 : </label>&nbsp;
						<input type="text" name="appTitle" class="col-7">
						</div>
						<input type="hidden" name="memberVO.id" value="${sessionScope.mvo.id}">
						<input type="hidden" name="appNo" value="${apno}">
						<input type="hidden" name="command" value="거절">
					</div>
				</div>

				<div class="control-group form-group col-10 offset-lg-1">
					<!-- 스마트 에디터 -->
					<div class="controls">
						<textarea name="appContents" id="appContents" rows="10" cols="100"
							style="width:100%; height:412px;"></textarea>
						<!-- <textarea rows="10" cols="100" class="form-control" id="#" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="문의내용"></textarea> -->
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="submit" id="savebutton"
					class="btn btn-sub-2-gnt btn-block col-10 offset-lg-1">작성완료</button>
			</form>
		</div>

	</div>
	<!-- /.row -->
<img src="" style="width:100%;height:auto">
</div>
<!-- /.container -->


