<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">�� �ۼ�</h4>
</div>
<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
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
					<!-- ����Ʈ ������-->
					<div class="controls">
						<textarea rows="10" cols="100" class="form-control" id="#" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="���ǳ���"></textarea>
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="submit" class="btn btn-sub-2-gnt btn-block" id="#">�۾���</button>
			</form>
		</div>

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->
