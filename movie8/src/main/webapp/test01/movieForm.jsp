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
<title>영화등록창</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function backToList(obj){ <%-- 자바스크립트 function --%>
	obj.action = "${contextPath}/test01/adminmenu.jsp";
	obj.submit();

}
function check(){
	if(form.title.value.length == 0){
		alert("제목을 입력하세요.");
		 form.title.focus();
		 return false;
	}

	if(form.genre.value.length == 0){
		alert("장르를 입력하세요.");
		 form.genre.focus(); 
		 return false;
	}
}
</script>
<style>
a {text-decoration:none; color:black;}
</style>
</head>
<body>
<form method ="post" action ="${contextPath}/movie01/addMovie.do" >
<h1 style ="text-align:center">영화등록</h1>
<table align="center">
  <tr>
    <td width="200"><p align ="right">영화제목</td>
    <td width="400"><input type ="text" name ="title"></td>
  </tr>
  <tr>
    <td width="200"><p align ="right">영화장르</td>
    <td width="400"><input type ="text" name ="genre" ></td>
  </tr>

  <tr>
    <td width="200"><p>&nbsp;</p></td>
    <td width="400"><input type ="submit" value="등록하기" onclick="return check()">
    <input type = button value ="취소" onclick ="backToList(this.form)"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>