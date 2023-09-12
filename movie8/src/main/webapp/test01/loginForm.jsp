<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value ="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화예매사이트</title>
<script type ="text/javascript">
function idCheck(){
	var loginform = document.loginform;
	var id = loginform.id.value;
	var pwd = loginform.pwd.value;
	
	if((id.length == 0 || id == "")||(pwd.length == 0 || pwd == "")){
		alert("아이디와 비밀번호는 필수입니다.");
		return false;
	}
}
</script>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<form name="loginform" action="login.do" method="post" align="center">
<h1 style ="text-align:center">로그인</h1>
아이디: <input type="text" name="id"><br><br>
비밀번호: <input type="password" name="pwd"><br><br>
<input type="submit" value="로그인" onclick="return idCheck()">
<input type="reset" value="다시입력"><br><br>
<a href="userForm.jsp">회원가입</a>
</form><br>
</body>
</html>