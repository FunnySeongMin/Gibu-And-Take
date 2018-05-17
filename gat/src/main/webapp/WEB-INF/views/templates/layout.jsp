<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- tiles framework 선언부 -->    
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		 <!-- Bootstrap core CSS -->
		 <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		 <!-- Custom styles for this template -->
   		 <link href="${pageContext.request.contextPath}/resources/css/gat-style.css" rel="stylesheet">
   		 <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
		<!-- font awesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css" integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9" crossorigin="anonymous">
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="main" /> 
		<tiles:insertAttribute name="footer" />
		
	    <!-- Bootstrap core JavaScript -->
	    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	    <script src="${pageContext.request.contextPath }/resources/jquery/jquery.min.js"></script>
	    <script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	    <script type="text/javascript" src="/gat/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
	    <script type="text/javascript">
	    	<!-- 스마트 에디터-->
			$(function() {
				//전역변수
				var obj = [];
				//스마트에디터 프레임생성
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : obj,
					elPlaceHolder : "appContents",
					sSkinURI : "/gat/resources/editor/SmartEditor2Skin.html",
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : false,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : false,
					}
				});
				//전송버튼
				$("#savebutton").click(function() {
					//id가 smarteditor인 textarea에 에디터에서 대입
					obj.getById["appContents"].exec("UPDATE_CONTENTS_FIELD", []);
					//폼 submit
					$("#contactForm").submit();
				})
			});
			
			<!-- 로그인 아이디 비밀번호 확인 : 아이디 중복체크, 아이디 길이확인, 비밀번호 일치여부 -->
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
						alert("아이디를 확인하세요!");
						return false;
					}
					else if (checkResultPassword=="") {
						alert("비밀번호를 확인하세요!");
						return false;
					}
				});//submit
			});//ready
		</script>
	</body>
	
</body>
</html>