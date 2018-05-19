<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<!-- 마일리지 충전 조건 -->
$(document).ready(function(){
	var addvolumeResult="";
	var exchangevolumeResult="";
	$("#submitBtn").click(function(){
		if($("#addVolume").val()<1000) {
			alert("충전할 금액은 1000원 이상이어야 합니다.")
			$("#addVolume").val("").focus()
			addvolumeResult="";
		} else if($("#addVolume").val()>100000) {
			alert("충전 금액은 1회 100,000원 이하입니다.")
			$("#addVolume").val("").focus()
			addvolumeResult="";
		} 
		else{
			confirmResult = confirm($("#addVolume").val()+"원 충전하시겠습니까?")
			if(confirmResult)
				addvolumeResult=$("#addVolume").val();
			else {
				addvolumeResult="";
				alert("충전이 취소되었습니다.")
				}
		}
	})//click
	$("#addMileageForm").submit(function(){
		if(addvolumeResult==""){
			return false;
		}
	})//submit
});//ready
</script>
<!-- 마일리지 페이지 기능 탭 -->
    <div class="container my-5">

		<div class="row">

			<div class="col-lg-3">
				<div class="list-group">
					<a href="${pageContext.request.contextPath }/member/addMileage.do" class="list-group-item active">마일리지 충전</a>
					<a href="${pageContext.request.contextPath }/member/exchangeMileage.do" class="list-group-item">마일리지 환전</a>
					<a href="${pageContext.request.contextPath }/member/readMyMileageTradeList.do?nowPage=1" class="list-group-item">마일리지 내역</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->
			
<!-- 마일리지 충전 페이지 -->
			<div class="col-lg-9">
				<h4 class="mb-4">마일리지 충전</h4>
				<div class="card card-block login-form p-5">
					<div class="jumbotron">
						"Gibu&Take"는 마일리지제로 운영됩니다. <br>
						마일리지 충전을 통해 유익한 재능 기부에 참여하세요!
					</div>
					<div class="card-body">
						<!-- 마일리지 충전 -->
						<form action="addMileage.do" method="post" id="addMileageForm">
						<input type="hidden" name="mugNo" value="1">
						<input type="hidden" name="mvo" value="${sessionScope.mvo}">
							<div class="form-group">
								보유 마일리지: ${sessionScope.mvo.mileage}원<br>
								<input type="number" class="form-control" name="mtVolume" id="addVolume" placeholder="충전할금액을 입력하세요">원
							</div>
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input" id="#">
								<label class="custom-control-label" >상기 내역에 동의합니다.</label>
							</div>
							<button type="submit" class="btn btn-point-gnt my-4" id="submitBtn">충전</button>
						</form>
					</div>
				</div>
			</div>
			<!-- /.col-lg-9 -->
		</div>
	</div>
	<!-- /.container -->