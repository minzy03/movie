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
<title>예매확인</title>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<div align="center">
<h3>예매확인</h3>
<h4>예매하신 영화정보입니다.</h4>
<hr/>
 <h1> 
 영화명: <c:out value="${reservation.movieName }"/><br> 좌석:
 <c:forEach var="reserve" items="${reservation.seat}">
 <c:out value="${reserve}"/><br>
 </c:forEach><br>
 발급번호: <c:out value="${reservation.resid}"/> <br>
 </h1>
<a href="${contextPath}/reservation01/cancellation.do">예매취소하기</a><br><br>
<a href="${contextPath}/test01/userMenu.jsp">메인메뉴로이동</a>
</div>
</body>
</html>