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
<title>메인페이지</title>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<c:if test="${not empty param.id}">
 <c:if test="${param.id=='admin' }">
<h1>관리자로 로그인 했습니다.</h1>
<a href="movieForm.jsp">영화등록하기</a><br><br>
<a href="${contextPath}/movie01/movieList.do">영화목록보기</a><br><br>
<a href="${contextPath}/movie01/movieList.do">영화삭제하기</a><br><br>
 </c:if>
 <c:if test="${param.id !='admin'}">
 <h1> 환영합니다. <c:out value="${param.id}" />님!!!</h1>
<a href="${contextPath}/reservation01/movieList.do">영화예매하기</a><br><br>
<a href="${contextPath}/reservation01/confirmation.do">예매확인하기</a><br><br>
<a href="${contextPath}/reservation01/cancellation.do">예매취소하기</a><br><br>
 </c:if>
</c:if>
</body>
</html>