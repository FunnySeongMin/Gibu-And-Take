<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">�����ϱ�</h4>
</div>
<!-- /.Page Heading -->
<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-6 offset-lg-3 my-4">
			<form name="sentMessage" id="contactForm" novalidate>
				<div class="control-group form-group">
					<div class="controls">
						<label>�ۼ���</label>
						<input type="tel" class="form-control" id="name" required data-validation-required-message="Please enter your phone number.">
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<input type="text" class="form-control" id="title" required data-validation-required-message="Please enter your name." placeholder="��������">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="���ǳ���"></textarea>
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="submit" class="btn btn-sub-2-gnt btn-block" id="sendMessageButton">�����ϱ�</button>
			</form>
		</div>

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->