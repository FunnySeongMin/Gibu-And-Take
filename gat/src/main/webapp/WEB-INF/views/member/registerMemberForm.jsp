<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="container mt-5 mb-5">
	<div class="row">
		<div class="col-md-4 offset-md-4">				
			<div class="card login-form pt-5 pb-5">
				<div class="card-body">
					<!--NAVER �α��� -->
					<button type="submit" class="btn btn-success btn-block">���̹� ���̵�� �����ϱ�</button>
					<div class="divider mt-4">						
						<span>�Ǵ�<span>
					</div>
					<!-- �Ϲ� �α��� -->
					<form action="" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="id" placeholder="���̵�">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="password" placeholder="��й�ȣ">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="password" placeholder="��й�ȣ ��Ȯ��">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="name" placeholder="�̸�">
						</div>
						<div class="form-group">
							<label>�������</label>
							<input type="date" class="form-control" name="birthday">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" name="name" placeholder="�̸���">
						</div>
						<div class="form-group">
							<label>�ּ�</label>
							<button type="" class="btn btn-sm">�˻�</button>
							<input type="text" class="form-control" name="address">
						</div>
						<button type="submit" class="btn btn-point-gnt btn-block">ȸ������</button>
					</form>
				</div>
				<div class="card-body text-center">
					<div class="divider"></div>
					<span class="small-txt desc-color mr-1">�̹� ��ξ�����ũ ������ �����Ű���?</span><a class="small-txt point-txt-gnt" href="${pageContext.request.contextPath }/member/login.do">�α���</a>
				</div>
			</div>
		</div>
	</div>
</div>