<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<br><br>
<!-- 마일리지 내역 보기  -->
<h2>내역보기^0^</h2>
<table>
  <tr>
    <th>거래 일시</th> <th>거래 분류</th> <th>거래량</th>
  </tr>
  <c:forEach items="${list}" var="list">
    <tr>
  		<td>${list.mtRegdate}</td><td>${list.mugVO.mugName}</td><td>${list.mtVolume}</td>
    </tr>
  </c:forEach>

</table>
<br><br>
</body>
</html>