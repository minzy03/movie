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
<c:choose>
  <c:when test='${msg=="addUser"}'>
    <script>
     window.onload=function(){
     alert("회원을 등록했습니다.");
     }
     </script>
     </c:when>
     <c:when test='${msg=="modified"}' >
      <script>
        window.onload=function(){
        	alert("회원정보를 수정했습니다.");
        }
      </script>
      </c:when>
      <c:when test='${msg=="deleted"}' >
      <script>
        window.onload=function(){
        	alert("회원정보를 삭제했습니다.");
        }
      </script>
      </c:when>
    </c:choose>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<style>
 .cls1 {font-size:40px; text-align:center;}
 .cls2{font-size:20px; text-align:center;}
 a {text-decoration:none; color:black;}
</style>
</head>
<body>
<p class = "cls2">회원정보</p>
<table align="center" border="1">
<tr align="center" bgcolor="#b3d9ff">
 <td width="7%"><b>아이디</b></td>
 <td width="7%"><b>비밀번호</b></td>
 <td width="7%"><b>이름</b></td>
 <td width="7%"><b>이메일</b></td>
 <td width="7%"><b>가입일</b></td>
 <td width="7%"><b>삭제</b></td>
</tr>
<c:choose>
  <c:when test="${ empty userList }" >
    <tr>
      <td colspan=6 align ="center">
        <b>등록된 회원이 없습니다.</b>
      </td>
    </tr>
  </c:when>
  <c:when test="${!empty userList}" >
    <c:forEach var="user" items="${userList}">
      <tr align ="center">
        <td>${user.id}</td>
        <td>${user.pwd}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.joinDate}</td>
        <td><a href ="${contextPath}/user01/deleteUser.do?id=${user.id}">삭제</a></td>
      </tr>
    </c:forEach>
  </c:when>
</c:choose>
</table>
<a href = "${contextPath}/user01/userForm.do"><p class = "cls2">회원가입하기</a></p>
</body>
</html>