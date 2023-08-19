<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보</title>
<style>
	table, tr, th, td {
		border-collapse: collapse;
	}
	th, td {
		padding: 10px;
	}
</style>
</head>
<body>
	<h2>학생정보</h2>[<a href="/jwbook/studentControlMyBatisAnnotation">새로고침</a>]
	<hr>
	<table border="1">
		<tr>
			<th>id</th>
			<th>이름</th>
			<th>대학</th>
			<th>생일</th>
			<th>이메일</th>
			<th>삭제하기</th>
			<th>수정하기</th>
		</tr>
		<c:forEach items="${students}" var="s">
		<tr id="${s.id}">
			<td>${s.id}</td>
			<td>${s.username}</td>
			<td>${s.univ}</td>
			<td>${s.birth}</td>
			<td>${s.email}</td>
			<td><button type="button" onclick="location.href='/jwbook/studentControlMyBatisAnnotation?action=delete&id=${s.id}'">삭제</button></td>
			<!-- <td><a href="/jwbook/studentControl?action=delete&id=${s.id}">삭제</a></td>-->
			<td><button type="button" onclick="location.href='/jwbook/studentControlMyBatisAnnotation?action=edit&id=${s.id}'">수정</button></td>
		</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<h2>학생 추가</h2>
	<form method="post" action="/jwbook/studentControlMyBatisAnnotation?action=insert">
		<label>이름</label>
		<input type="text" name="username"><br>
		<label>대학</label>
		<input type="text" name="univ"><br>
		<label>생일</label>
		<input type="text" name="birth"><br>
		<label>이메일</label>
		<input type="text" name="email"><br>
		<button type="submit">등록</button>
	</form>
</body>
</html>