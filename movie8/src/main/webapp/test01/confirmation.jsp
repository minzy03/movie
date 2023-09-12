<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, test01.*" isELIgnored="false"%>
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
<title>예매확인</title>
<style>
 .cls1 {font-size:40px; text-align:center;}
 .cls2{font-size:20px; text-align:center;}
 a {text-decoration:none; color:black;}
</style>
</head>
<body>
<form name="loginform" action="${contextPath}/reservation01/okConfirmation.do" method="post" align="center">
<h1 style ="text-align:center">예매확인</h1>
발급번호: <input type="text" name="resid"><br><br>
<input type="submit" value="확인"/>
<input type="reset" value="다시입력"/><br><br>
</form><br>

</body>
</html>