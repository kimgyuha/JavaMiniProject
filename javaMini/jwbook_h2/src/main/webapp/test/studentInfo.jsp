<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보</title>
</head>
<body>
  <h2>학생정보</h2>[<a href="/jwbook/studentControl1">새로고침</a>]
  <hr>
  <table border="1">
    <tr>
    <th>이름</th><th>대학</th>
    </tr>
    <c:forEach items="${students}" var="s" >
      <tr>
        <td>${s.username}</td> 
        <td>${s.univ}</td> 
      </tr>
    </c:forEach>
  </table>
  <hr>
  <h2>학생 추가</h2>
  <hr>
  <form method="post" action="/jwbook/studentControl1?action=insert">
    <label>이름</label>
    <input type="text" name="username"><br>
    <label>대학</label>  
    <input type="text" name="univ">
    <button type="submit">추가</button>
  </form>
  <!-- 여기서부터 추가 -->
  

  <!-- 여기까지 -->
</body>
</html>