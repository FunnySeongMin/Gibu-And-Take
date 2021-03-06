$(document).ready(function(){
	$("#entryBtn").click(function(){
		alert("로그인 후 이용해 주세요");
		location.href="../member/loginForm.do";
	});
	$("#checkEntryBtn").click(function(){
		alert("재능기부는 한번만 참여 가능");
		return false;
	});
	$("#entryDonation").submit(function(){
		//사용할 마일리지를 적지 않았을 경우
		if($("#tdMileage").val() == "" || $("#tdMileage").val() == null){
			alert("사용할 마일리지 액수를 적어주세요");
			return false;
		// 입력한 마일리지가 0 인 경우
		}if(parseInt($("#tdMileage").val())==0){
			alert("마일리지 0 이상부터 가능합니다.")
			return false;
		// 입력한 마일리지 액수가 보유 마일리지 액수보다 클 경우
		}else if(parseInt($("#tdMileage").val()) > parseInt($("#userMileage").text())){
			alert("보유하고 있는 마일리지 액수를 초과하였습니다.");
			return false;
		}else if(!$('input:checkbox[id="entryAgree"]').is(":checked")){
			alert("상기 내용에 동의하지 않으셨습니다. 동의해주세요.");
			return false;
		}
	});
	// '취소'버튼을 누르면 modal을 없앤다
	$("#cancelBtn").click(function(){
		$("#entryForm").modal("hide");
	});	
});