<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value ="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자메뉴</title>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<h1> 사용자메뉴</h1>
<a href="${contextPath}/movie01/movieList.do">영화예매하기</a><br><br>
<a href="${contextPath}/reservation01/confirmation.do">예매확인하기</a><br><br>
<a href="${contextPath}/reservation01/cancellation.do">예매취소하기</a><br><br>

</body>
</html>