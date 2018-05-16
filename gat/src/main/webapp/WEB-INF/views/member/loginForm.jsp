<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5 mb-5">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			
			<div class="card card-block login-form pt-5 pb-5">
				<div class="card-body">
					<!--NAVER �α��� -->
					<button type="submit" class="btn btn-success btn-block">Naver �α���</button>
					<div class="divider mt-4">						
						<span>�Ǵ�<span>
					</div>
					<!-- �Ϲ� �α��� -->
					<form action="login.do" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="id" placeholder="ID" required="required">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password" placeholder="Password" required="required">
						</div>
						<button type="submit" class="btn btn-point-gnt btn-block">�α���</button>
					</form>
				</div>
				<div class="card-body text-center">
					<span class="small-txt desc-color mr-1">���� ������ �����Ű���?</span><a class="small-txt point-txt-gnt" href="${pageContext.request.contextPath }/member/registerMemberForm.do">�����ϱ�</a>
					<!-- <div class="divider mt-2 mb-2"></div>
					<span class="small-txt desc-color mr-1">��й�ȣ�� �����̳���?</span><a class="small-txt point-txt-gnt" href="find_password.html">��й�ȣ ã��</a> -->
				</div>
				
				
			</div>
		</div>
	</div>

</div>
<!-- /.container -->