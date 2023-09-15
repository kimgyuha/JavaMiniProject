<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  int n1 = Integer.parseInt(request.getParameter("n1"));//Integer.parseInt : 문자형형태를 정수형으로 바까줌
  
  int n2 = Integer.parseInt(request.getParameter("n2"));
  
  long result = 0;
  
  switch(request.getParameter("op")){//op라는 매개변수에 뭐가 들어잇는지 찾아와서 거기 잇는 값을 구분해서
  case "+": result = n1+n2; break;
  case "-": result = n1-n2; break;
  case "*": result = n1*n2; break;
  case "/": result = n1/n2; break;
  
  }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>게산결과 - jsp</h2>
  <hr>
    결과 : <%=result %>
</body>
</html>