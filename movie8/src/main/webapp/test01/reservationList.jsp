<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매내역</title>
<style>
 .cls1 {font-size:40px; text-align:center;}
 .cls2{font-size:20px; text-align:center;}
 a {text-decoration:none; color:black;}
</style>
</head>
<body>
<h1 class = "cls2">예매내역</h1>
<table align="center" border="1">
<tr align="center" bgcolor="#b3d9ff">
 <td width="7%"><b>예매번호</b></td>
 <td width="7%"><b>좌석</b></td>
 <td width="7%"><b>영화</b></td>
 <td width="7%"><b>영화아이디</b></td>
 <td width="7%"><b>취소</b></td>
</tr>
<c:choose>
  <c:when test="${ empty reservationList}" >
    <tr>
      <td colspan=5 align ="center">
        <b>예매 내역이 없습니다.</b>
      </td>
    </tr>
  </c:when>
  <c:when test="${!empty reservationList}" >
    <c:forEach var="reserve" items="${reservationList}">
      <tr align ="center">
        <td>${reserve.resid}</td>
        <td>${reserve.seat}</td>
        <td>${reserve.movieName}</td>
        <td>${reserve.movieId}</td>
        <td><a href ="${contextPath}/reservation01/okCancellation.do?resid=${reserve.resid}">취소</a></td>
      </tr>
    </c:forEach>
  </c:when>
</c:choose>
</table>
<a href="${contextPath}/test01/userMenu.jsp"><p class="cls2">사용자메뉴로이동</a></p>
</body>
</html>