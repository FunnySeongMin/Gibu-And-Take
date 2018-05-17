<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<br><br>
<h2>충전하기^0^</h2>
<form name="addMileageForm" method="post" action="addMileage.do">
<input type="hidden" name="mugNo" value="1">
<input type="hidden" name="mvo" value="${sessionScope.mvo}">
<input type="number" name="mtVolume" id="mtVolume" placeholder="충전할 금액" required="required">원 
<!-- <button type="submit" id="submitBtn">충전</button> <br><br><br><br> -->
<button type="submit" id="submitBtn">충전</button> <br><br><br><br> 
보유 마일리지: ${sessionScope.mvo.mileage}원
<!-- 현재 마일리지 : <span id="myMileageView"></span>원 -->
</form>
<hr>
<br><br>
<h2>환전하기^0^</h2>
<form name="changeMileageForm" method="post" action="exchangeMileage.do">
<input type="hidden" name="mugNo" value="3">
<input type="hidden" name="mvo" value="${sessionScope.mvo}">
<input type="number" name="mtVolume" placeholder="환전할 금액" required="required">원 
<!-- <button type="submit" id="submitBtn">환전</button> <br><br><br><br> -->
<button type="submit" id="submitBtn">환전 신청</button> <br><br><br><br> 
보유 마일리지: ${sessionScope.mvo.mileage}원
<!-- 현재 마일리지 : <span id="myMileageView"></span>원 -->
</form>
<br><br>
<hr>
<br><br>
<h2>내역보기^0^</h2>
<table>
</table>
<br><br>