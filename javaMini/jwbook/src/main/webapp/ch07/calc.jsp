<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean class="ch08.Calculator"  id="calc"/>
<jsp:setProperty name="calc" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산 결과-JSP</h2>
	<hr>
	결과 : <%=calc.calc() %>

</body>
</html>