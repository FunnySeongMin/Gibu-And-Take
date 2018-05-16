<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container mt-5 mb-5">
	<div class="row">
		<div class="col-md-4 offset-md-4">				
			<div class="card login-form pt-5 pb-5">
				<div class="card-body">
					<!--NAVER 로그인 -->
					<button type="submit" class="btn btn-success btn-block">네이버 아이디로 가입하기</button>
					<div class="divider mt-4">						
						<span>또는<span>
					</div>
					<!-- 회원가입 폼 -->
					<form action="registerMember.do" method="post" id="registerForm">
                     <div class="form-group">
                        <input type="text" class="form-control" name="id" id="id" placeholder="아이디" required="required">
                         <span id="checkIdView"></span>
                     </div>
                     <div class="form-group">
                        <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호" required="required">
                     </div>
                     <div class="form-group">
                        <input type="password" class="form-control" name="passwordCon" id="passwordCon" placeholder="비밀번호 재확인" required="required">
                    	<span id="checkPasswordView"></span>
                     </div>
                     <div class="form-group">
                        <input type="text" class="form-control" name="name" placeholder="이름" required="required">
                     </div>
                     <div class="form-group">
                        <label>생년월일</label>
                        <input type="date" class="form-control" name="birthday" required="required">
                     </div>
                     <div class="form-group">
                        <label>주소</label>
                        <button type="" class="btn btn-sm">검색</button>
                        <input type="text" class="form-control" name="address" required="required">
                     </div>
                     <div class="form-group">
                        <input type="email" class="form-control" name="email" placeholder="이메일" required="required">
                     </div>
                     <button type="submit" class="btn btn-point-gnt btn-block">회원가입</button>
                  </form>
				</div>
				<div class="card-body text-center">
					<div class="divider"></div>
					<span class="small-txt desc-color mr-1">이미 기부앤테이크 계정이 있으신가요?</span><a class="small-txt point-txt-gnt" href="${pageContext.request.contextPath }/member/login.do">로그인</a>
				</div>
			</div>
		</div>
	</div>
</div>