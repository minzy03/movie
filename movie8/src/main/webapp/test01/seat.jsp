<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*, test01.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
List<Reservation> reservationList =(List<Reservation>) request.getAttribute("reservationList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석선택창</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function backToList(obj){ <%-- 자바스크립트 function --%>
	obj.action = "${contextPath}/test01/userMenu.jsp";
	obj.submit();
}
</script>
</head>
<body>
<div align="center">
<h2>영화예매페이지</h2>
<h4>좌석을 체크한 후에 예약 버튼을 클릭하세요</h4>
<hr/>
<form name="reserve" action="${contextPath}/reservation01/newReservation.do" method="post">	
 <b>좌석 배치도</b><br/>
 &nbsp;&nbsp;
 <% for(char c='A'; c<='E'; c++) { %>
  <small><%=c %></small>&nbsp;&nbsp;
 <% } %>
<br/>

<% for(int i=1; i<=9; i++) { %>
    <%=i %>
    <% for(char c='A'; c<='E'; c++) { %>
        <% String seat = c + "-" + i;
        boolean isReserved = false; // 좌석이 예약되었는지 여부를 나타내는 플래그
        for (Reservation reservation : reservationList) {
            if (reservation.getSeat().equals(seat)) {
                isReserved = true;
                break;
            }
        }
        %>
        <input type="checkbox" name="seat" value="<%=c %>-<%=i %>" 
        <% if (isReserved) { %>disabled<% } %>>
        <% } %>
    <br>
<% } %>


<input type="hidden" name="movieName" value="${movieName}">
<input type="hidden" name="movieId" value="${movieId}">
	
			
<br/>
<input type="submit" value="예매" />
<input type = button value ="취소" onclick ="backToList(this.form)"/>
</form>
</div>
</body>
</html>