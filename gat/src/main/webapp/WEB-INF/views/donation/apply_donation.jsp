<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Page Heading -->
	<div class="page-heading bg-sub-3-gnt">
		<h4 class="py-5 text-center">��ɱ�� ��û�ϱ�</h4>
	</div>
	
	<!-- /.Page Heading -->
	
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-10 offset-lg-1 my-4">
				<h3 class="mt-4 mb-3">��ɱ���� �⺻ ����
						<small>info</small>
					</h3>
				<div class="jumbotron">
					��ɱ���� �⺻ ����
				</div>
			</div>
		</div>
	</div>
	<!-- /.Page Content -->
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-10 offset-lg-1 my-4" data-spy="scroll" data-target="#navbar-dp-info" data-offset="50">
				<form action="#" method="#">
					<div class="control-group form-group">
						<div class="controls">
							<label>��ɱ�� ������Ʈ��</label>
							<input type="text" class="form-control" id="name" required data-validation-required-message="��ɱ�� ������Ʈ���� �Է��ϼ���">
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>��ɱ�� �Ⱓ</label>
							<input type="date" id="start_date"> - <input type="date" id="end_date">
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>�ּ�</label>
							<button type="" class="btn btn-sm">�˻�</button>
							<input type="text" class="form-control" name="address">
						</div>
						<div class="view-map"></div>
					</div>
					<div class="control-group form-group">
						<label>�̹���</label>
						<button type="" class="btn btn-sm">�˻�</button>
						<input type="upload" class="form-control" name="address">
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>��ɱ�� ������Ʈ �Ұ�</label>
							<textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="���ǳ���"></textarea>
						</div>
					</div>
					<div id="success"></div>
					<!-- For success/fail messages -->
					<button type="submit" class="btn btn-sub-2-gnt btn-block" id="apply_gibu">��ɱ�� ��û�ϱ�</button>
				</form>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
