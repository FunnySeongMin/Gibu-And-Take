$(document).ready(function(){
	$("#writeReview").click(function(){
		alert("로그인 후 이용해 주세요!")
		location.href="../member/loginForm.do";
	});
	$("#addReview").submit(function(){
		// 후기글 제목을 적지 않았을 경우
		if($("#rpTitle").val()=="" || $("#rpTitle").val()==null){
			alert("후기 제목을 작성해주세요");
			return false;
		// 후기에 대한 별점을 주지 않았을 경우
		}else if($("#rpRate").val()=="" || $("#rpRate").val()==null){
			alert("후기 별점을 작성해주세요");
			return false;
		// 후기 내용을 적지 않았을 경우
		}else if($("#rpDontents").val()=="" || $("#rpDontents").val()==null){
			alert("후기 내용을 작성해주세요");
			return false;
		}
	});
	// '취소'버튼을 누르면 modal을 없앤다
	$("#cancelBtn").click(function(){
		$("#entryForm").modal("hide");
	});	
});