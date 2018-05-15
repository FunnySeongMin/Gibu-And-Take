<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  script  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var checkResultId="";
	$("#id").keyup(function(){
		var id=$(this).val().trim();
		if(id.length<3 || id.length>10){
			$("#checkIdView").html("아이디는 3자이상 10자 이하여야 합니다.").css("color","#edbf71");
			checkResultId="";
			return;
		}
		else 
			$("#checkIdView").html("");
		$.ajax({
			type:"get",
			url:"checkId.do",				
			data:"id="+id,	
			success:function(data){	
				if(data=="fail"){
					$("#checkIdView").html(id+"은 이미 존재하는 아이디입니다.").css("color","#f35b56");
					checkResultId="";
				}else{					
					$("#checkIdView").html(id+"는 사용 가능한 아이디입니다.").css("color","#1e878d");		
					checkResultId=id;
				}					
			}//success		
		});//ajax
	});//keyup	
	$("#password").keyup(function(){
		var passwordCon = $("#passwordCon").val();
		var password = $("#password").val();
		var checkResultPassword="";
		if(passwordCon!="" && password != passwordCon) {//비밀번호와 비밀번호 확인이 일치하지 않는 경우
			$("#checkPasswordView").html("패스워드와 일치하지 않습니다").css("color","#f35b56");
			checkResultPassword="";
		}else if (passwordCon=="") {
			$("#checkPasswordView").html("");
			checkResultPassword="";
		}else {//비밀번호와 비밀번호 확인이 일치하여 진행 가능한 경우
			$("#checkPasswordView").html("패스워드와 일치합니다").css("color","#1e878d");
			checkResultPassword=password;
		}
	});//keyup
	$("#passwordCon").keyup(function(){
		var passwordCon = $("#passwordCon").val();
		var password = $("#password").val();
		if(passwordCon!="" && password != passwordCon) {//비밀번호와 비밀번호 확인이 일치하지 않는 경우
			$("#checkPasswordView").html("패스워드와 일치하지 않습니다").css("color","#f35b56");
			checkResultPassword="";
		}else if (passwordCon=="") {
			$("#checkPasswordView").html("");
			checkResultPassword="";
		}else {//비밀번호와 비밀번호 확인이 일치하여 진행 가능한 경우
			$("#checkPasswordView").html("패스워드와 일치합니다").css("color","#1e878d");
			checkResultPassword=password;
		}
	});//keyup
	$("#registerForm").submit(function(){
		if(checkResultId==""){
			alert("아이디 중복 확인하세요!");
			return false;
		}
		else if (checkResultPassword=="") {
			alert("비밀번호 확인하세요!");
			return false;
		}
	});//submit
});//ready
</script>

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
 <form action="registerMember.do" method="post" name="registerForm">
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