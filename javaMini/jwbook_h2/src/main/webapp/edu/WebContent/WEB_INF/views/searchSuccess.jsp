<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
	<h2>회원정보</h2>
	<hr>
	<table border="1">
	<tr> <th>회원번호</th><th>회원아이디</th><th>회원이름</th><th>회원나이</th></tr>
	<c:forEach var="m" varStatus="i" items="${users}">
		<tr>
			<td>${i.usernumber}</td> <!--  -->
			
			<td>${u.userid}</td>
			<td>${u.username}</td>
			<td>${u.userage}</td>
			
		</tr>
	</c:forEach>
	</table>
</body></html>