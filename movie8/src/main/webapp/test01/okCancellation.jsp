<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value ="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취소완료</title>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<div align="center">
<h3>취소완료</h3>
<hr/>
 취소가 완료되었습니다.</h1><br><br>
<a href="${contextPath}/reservation01/reservationList.do">예매목록보기</a><br><br>
<a href="${contextPath}/test01/userMenu.jsp">메인메뉴로이동</a>

</div>
</body>
</html>