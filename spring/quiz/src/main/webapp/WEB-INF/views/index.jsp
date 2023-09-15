<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is a page for you to solve some quizes</title>
</head>
<body>
	<c:if test="${empty answer}">
		<form action="quizSubmitted" method="post">
			<label> 1. 1 + 1 = </label> 
			<input type="hidden" name="question" value="1">
			<input type="text" name="answer" />
			<button>Submit</button>
		</form>
	</c:if>
	
	<c:if test="${!empty answer}">
		<h1>Correct answer.</h1>
	</c:if>
</body>
</html>