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
	
<!-- 마일리지 환전 조건 !-->
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
<!-- 충전하기  -->
<br><br>
<h2>충전하기^0^</h2>
<form id="addMileageForm" method="post" action="addMileage.do">
<input type="hidden" name="mugNo" value="1">
<input type="hidden" name="mvo" value="${sessionScope.mvo}">
<input type="number" name="mtVolume" id="addVolume" placeholder="충전할 금액" required="required">원 
<!-- <button type="submit" id="submitBtn">충전</button> <br><br><br><br> -->
<button type="submit" id="submitBtn">충전</button> <br><br><br><br> 
보유 마일리지: ${sessionScope.mvo.mileage}원
<!-- 현재 마일리지 : <span id="myMileageView"></span>원 -->
</form>

<hr>
<br><br>
<!-- 환전하기  -->
<h2>환전하기^0^</h2>
<form id="exchangeMileageForm" method="post" action="exchangeMileage.do">
<input type="hidden" name="mugNo" value="3">
<input type="hidden" name="mvo" value="${sessionScope.mvo}">
<input type="number" name="exchangeVolume" id="exchangeVolume" placeholder="환전할 금액" required="required">원 
<!-- <button type="submit" id="submitBtn">환전</button> <br><br><br><br> -->
<button type="submit" id="submitBtn2">환전 신청</button> <br><br><br><br> 
보유 마일리지: ${sessionScope.mvo.mileage}원
<!-- 현재 마일리지 : <span id="myMileageView"></span>원 -->
</form>
<br><br>

<hr>
<br><br>
<!-- 마일리지 내역 보기  -->
<h2>내역보기^0^</h2>
<table>
</table>
<br><br>