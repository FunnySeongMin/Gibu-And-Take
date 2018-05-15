<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- tiles framework 선언부 -->    
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		 <!-- Bootstrap core CSS -->
		 <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		 <!-- Custom styles for this template -->
   		 <link href="${pageContext.request.contextPath}/resources/css/gat-style.css" rel="stylesheet">
		<!-- font awesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css" integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9" crossorigin="anonymous">
	</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="main" /> 
	<tiles:insertAttribute name="footer" />
</body>
</html>