<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회(회원 번호 검색)</title>
</head>
<body>
<h2>회원 정보 조회(회원 번호 검색)</h2>
	<form method="post" action="/jwbook/selectUser?action=success&number=${u.usernumber}">
  <input type="text" name="usernumber">
  <button type="submit" >조회</button>
 
  </form>
</body>
</html>