<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<!-- 마일리지 환전 조건 -->
$(document).ready(function(){
	$("#submitBtn2").click(function(){
		if($("#exchangeVolume").val()<10000) {
			alert("환전할 금액은 10000원 이상이어야 합니다.")
			$("#exchangeVolume").val("").focus()
			exchangevolumeResult="";
		} else if($("#exchangeVolume").val()>${sessionScope.mvo.mileage}) {
			alert("환전 금액이 보유 금액보다 많습니다.")
			$("#exchangeVolume").val("").focus()
			exchangevolumeResult="";
		} 
		else{
			confirmResult = confirm($("#exchangeVolume").val()+"원 환전하시겠습니까?")
			if(confirmResult)
				exchangevolumeResult=$("#exchangeVolume").val();
			else {
				exchangevolumeResult="";
				alert("환전이 취소되었습니다.")
				}
		}
	})//click
	$("#exchangeMileageForm").submit(function(){
		if(exchangevolumeResult==""){
			return false;
		}
	})//submit
});//ready
</script>
<!-- 마일리지 충전하기 -->
<div class="container my-5">

		<div class="row">

			<div class="col-lg-3">
				<div class="list-group">
					<a href="${pageContext.request.contextPath }/member/addMileage.do" class="list-group-item">마일리지 충전</a>
					<a href="${pageContext.request.contextPath }/member/exchangeMileage.do" class="list-group-item active">마일리지 환전</a>
					<a href="${pageContext.request.contextPath }/member/readMyMileageTradeList.do?nowPage=1" class="list-group-item">마일리지 내역</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<h4 class="mb-4">마일리지 환전</h4>
				<div class="card card-block login-form p-5">
				<div class="jumbotron">
						"Gibu&Take"에서 적립한 마일리지는 입력하신 계좌번호로 5일 내에 입금됩니다.
				</div>
					<div class="card-body">
						<!-- 마일리지 충전 -->
						<form id="exchangeMileageForm" method="post" action="exchangeMileage.do">
							<input type="hidden" name="mugNo" value="3">
							<input type="hidden" name="mvo" value="${sessionScope.mvo}">
							<div class="form-group">
								보유 마일리지: ${sessionScope.mvo.mileage}원
								<input type="number" class="form-control" name="mtVolume" id="exchangeVolume" placeholder="충전할 금액">원
							</div>
							<div class="form-group">
								<label>은행</label>
								<input type="text" class="form-control" name="#" placeholder="은행을 입력하세요">
							</div>
							<div class="form-group">
								<label>계좌번호</label>
								<input type="text" class="form-control" name="#" placeholder="계좌번호를 입력하세요">
							</div>
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input" id="#">
								<label class="custom-control-label" for="#">상기 내역에 동의합니다.</label>
							</div>
							<button type="submit" class="btn btn-point-gnt my-4"  id="submitBtn2">환전</button>
						</form>
					</div>
				</div>
			</div>
			<!-- /.col-lg-9 -->
		</div>
	</div>
	<!-- /.container -->