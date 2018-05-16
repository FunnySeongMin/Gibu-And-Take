<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<div class="container mt-5 mb-5">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			
			<div class="card card-block login-form pt-5 pb-5">
				<div class="card-body">
					<!--NAVER 로그인 -->
					<button type="submit" class="btn btn-success btn-block">Naver 로그인</button>
					<div class="divider mt-4">						
						<span>또는<span>
					</div>
					<!-- 일반 로그인 -->
					<form action="" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="id" placeholder="Enter ID">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="password" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-point-gnt btn-block">로그인</button>
					</form>
				</div>
				<div class="card-body text-center">
					<span class="small-txt desc-color mr-1">아직 계정이 없으신가요?</span><a class="small-txt point-txt-gnt" href="${pageContext.request.contextPath }/member/register.do">가입하기</a>
					<!-- <div class="divider mt-2 mb-2"></div>
					<span class="small-txt desc-color mr-1">비밀번호를 잊으셨나요?</span><a class="small-txt point-txt-gnt" href="find_password.html">비밀번호 찾기</a> -->
				</div>
				
				
			</div>
		</div>
	</div>

</div>
<!-- /.container -->