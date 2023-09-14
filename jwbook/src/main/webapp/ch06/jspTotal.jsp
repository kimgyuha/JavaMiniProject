<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		1.주석
		<!-- HTML주석 : 화면에서는 안보이고 소스보기에는 보임 컨테이너에서 따로 처리를 안하기 때문. -->
		<%--JSP주석 : 화면과 소스보기에서 둘 다 보이지 않음--%>
	</h3>
	
	<%!
			String[] members = {"김길동", "홍길동", "김사랑", "박사랑"};
			int num1 = 10;
			int calc(int num2){
				return num1 + num2;
			}
	%>
		
	<h3>
		2.calc(10) 메서드 실행 결과 :
		<%=calc(10) %>
	</h3>
	<h3>
		3.include : hello.jsp
	</h3>
	<%--<%@ include file="../hello.jsp" %> --%>
	
	<h3>4. 스크립트(배열 데이터 출력)</h3>
		<ul>
			<%
				for(String name: members){
			%>
				<li><%=name %></li>
				<% } %>
		</ul>
		
	<h3>5. 9단 출력 결과</h3>
	<%!
		int calc2(int n){
			return n * 9;
		}
	%>
	
	<%
		for(int i = 1; i < 10; i++){
	%>
	
		<%="9X" + i + "=" + calc2(i) %> <br>
		
	<%
		}
	%>
</body>
</html>