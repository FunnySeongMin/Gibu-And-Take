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
			$("#checkIdView").html("���̵�� 3���̻� 10�� ���Ͽ��� �մϴ�.").css("color","#edbf71");
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
					$("#checkIdView").html(id+"�� �̹� �����ϴ� ���̵��Դϴ�.").css("color","#f35b56");
					checkResultId="";
				}else{					
					$("#checkIdView").html(id+"�� ��� ������ ���̵��Դϴ�.").css("color","#1e878d");		
					checkResultId=id;
				}					
			}//success		
		});//ajax
	});//keyup	
	$("#password").keyup(function(){
		var passwordCon = $("#passwordCon").val();
		var password = $("#password").val();
		var checkResultPassword="";
		if(passwordCon!="" && password != passwordCon) {//��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʴ� ���
			$("#checkPasswordView").html("�н������ ��ġ���� �ʽ��ϴ�").css("color","#f35b56");
			checkResultPassword="";
		}else if (passwordCon=="") {
			$("#checkPasswordView").html("");
			checkResultPassword="";
		}else {//��й�ȣ�� ��й�ȣ Ȯ���� ��ġ�Ͽ� ���� ������ ���
			$("#checkPasswordView").html("�н������ ��ġ�մϴ�").css("color","#1e878d");
			checkResultPassword=password;
		}
	});//keyup
	$("#passwordCon").keyup(function(){
		var passwordCon = $("#passwordCon").val();
		var password = $("#password").val();
		if(passwordCon!="" && password != passwordCon) {//��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʴ� ���
			$("#checkPasswordView").html("�н������ ��ġ���� �ʽ��ϴ�").css("color","#f35b56");
			checkResultPassword="";
		}else if (passwordCon=="") {
			$("#checkPasswordView").html("");
			checkResultPassword="";
		}else {//��й�ȣ�� ��й�ȣ Ȯ���� ��ġ�Ͽ� ���� ������ ���
			$("#checkPasswordView").html("�н������ ��ġ�մϴ�").css("color","#1e878d");
			checkResultPassword=password;
		}
	});//keyup
	$("#registerForm").submit(function(){
		if(checkResultId==""){
			alert("���̵� �ߺ� Ȯ���ϼ���!");
			return false;
		}
		else if (checkResultPassword=="") {
			alert("��й�ȣ Ȯ���ϼ���!");
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
					<!--NAVER �α��� -->
					<button type="submit" class="btn btn-success btn-block">���̹� ���̵�� �����ϱ�</button>
					<div class="divider mt-4">						
						<span>�Ǵ�<span>
					</div>
<!-- ȸ������ �� -->
 <form action="registerMember.do" method="post" name="registerForm">
                     <div class="form-group">
                        <input type="text" class="form-control" name="id" id="id" placeholder="���̵�" required="required">
                         <span id="checkIdView"></span>
                     </div>
                     <div class="form-group">
                        <input type="password" class="form-control" name="password" id="password" placeholder="��й�ȣ" required="required">
                     </div>
                     <div class="form-group">
                        <input type="password" class="form-control" name="passwordCon" id="passwordCon" placeholder="��й�ȣ ��Ȯ��" required="required">
                    	<span id="checkPasswordView"></span>
                     </div>
                     <div class="form-group">
                        <input type="text" class="form-control" name="name" placeholder="�̸�" required="required">
                     </div>
                     <div class="form-group">
                        <label>�������</label>
                        <input type="date" class="form-control" name="birthday" required="required">
                     </div>
                     <div class="form-group">
                        <label>�ּ�</label>
                        <button type="" class="btn btn-sm">�˻�</button>
                        <input type="text" class="form-control" name="address" required="required">
                     </div>
                     <div class="form-group">
                        <input type="email" class="form-control" name="email" placeholder="�̸���" required="required">
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