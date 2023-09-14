<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container w-75 mt-5 mx-auto"> <!--  -->
		<h2>뉴스 목록</h2>
		<hr>
		<ul class="list-group">
			<c:forEach var="news" items="${newslist}" varStatus="status">
			<!--var는 변수, items는 값을 가져올 컬렉션, 전체 뉴스 목록을 가져오는 반복문 성격 -->
			<!--controller의 listNews 메서드에서 list(뉴스목록)를 받아와서 하나씩 출력-->
			<!--newslist와 news는 controller에서 전달받은 값 -->
				<li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
					<a href="news.nhn?action=getNews&aid=${news.aid}" class="text-decoration-none">
						[${status.count}] ${news.title}, ${news.newsdate}</a> 
						<!-- action=다음에 오는 게 컨트롤러의 메서드 이름/ &aid=다음에 오는게 특정 ~번째 뉴스 -->
						<!-- action이 getNews 로 하나씩 목록을 보여줌 -->
					<a href="news.nhn?action=deleteNews&aid=${news.aid}">
					<!--지울 뉴스의 aid를 액션으로 받아서 삭제-->
						<span class="badge bg-secondary"> &times; </span>
					</a>
				</li>
			</c:forEach>
		</ul>
		<hr>
		<c:if test="${error != null}">
			<div class="alert alert-danger alert-dismissible fade show mt-3">
				에러 발생 : ${error}
				<!--controller에서 error메세지를 넘기면 그 메세지를 출력 -->
				<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			</div>
		</c:if>
	
		<button class="btn btn-outline-info mb-3" type="button" data-bs-toggle="collapse" data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">뉴스 등록</button>
		<div class="collapse" id="addForm">
			<div class="card card-body">
				<form method="post" action="/jwbook/news.nhn?action=addNews" enctype="multipart/form-data">
					<!-- controller의 addNews에서 데이터를 받아서 새로운 뉴스 등록 -->
					<label class="form-Lable">제목</label>
					<input type="text" name="title" class="form-control">
					<!-- 데이터 형식 지정 -->
					<label class="form-Label">이미지</label>
					<input type="file" name="file" class="form-control">
					<label class="form-Label">기사 내용</label>
					<textarea cols="50" rows="5" name="content" class="form-control"></textarea>
					<button type="submit" class="btn btn-success mt-3">저장</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>