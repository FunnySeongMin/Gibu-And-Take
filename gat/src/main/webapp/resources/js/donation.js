$(document).ready(function(){
	$("#entryDonation").submit(function(){
		//alert($("#userMileage").text());
		//사용할 마일리지를 적지 않았을 경우
		if($("#tdMileage").val() == "" || $("#tdMileage").val() == null){
			alert("사용할 마일리지 액수를 적어주세요");
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