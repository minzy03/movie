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
<title>예매완료</title>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<div align="center">
<h3>예매완료</h3>
<hr/>
<c:if test="${empty param.seat}">
<h1>예매가 완료되지 않았습니다.</h1>
 </c:if>
 <c:if test="${not empty param.seat}">
 <h1> 
 영화명: <c:out value="${param.movieName }"/><br> 좌석:
 <c:forEach var="reserve" items="${seat}">
 <c:out value="${reserve}"/><br>
 </c:forEach>
 발급번호: <c:out value="${resid}"/> <br>
 예매가 완료되었습니다.</h1>
<a href="${contextPath}/movie01/movieList.do">영화예매하기</a><br><br>
<a href="${contextPath}/reservation01/reservationList.do">예매목록보기</a><br><br>
<a href="${contextPath}/reservation01/cancellation.do">예매취소하기</a><br><br>
<a href="${contextPath}/test01/userMenu.jsp">메인메뉴로이동</a>
 </c:if>

</div>
</body>
</html>