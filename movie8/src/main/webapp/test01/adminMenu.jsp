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
<title>관리자메뉴</title>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<h1> 관리자메뉴</h1>
<a href="movieForm.jsp">영화등록하기</a><br><br>
<a href="${contextPath}/movie01/adminMovieList.do">영화목록보기</a><br><br>
<a href="${contextPath}/movie01/adminMovieList.do">영화삭제하기</a><br><br>
</body>
</html>