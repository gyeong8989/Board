<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/resources/includes/link.jsp" %>
<link rel="stylesheet" href="resources/ces/css/common.css">
</head>
<body>
	<div class="container-md" style="width:60% margin:100px quto; text-align:enter;">
	<h1 class="mb-5 m-5" style="text-align:center">회원가입</h1>
		<form action="/MemberJoin.do" method="post">
			<input type=email name=email placeholder="exampl@example.com" class="form-control m-2">
			<input type=password name=pwd placeholder="패스워드 입력" class="form-control m-2">
			<input name=addr1 placeholder="주소1 입력" class="form-control m-2">
			<input name=addr2 placeholder="주소2 입력" class="form-control m-2">
			<input type=submit value=가입하기 class="btn btn-primary w-100 m-2">
			<input type=reset value=RESET class="btn btn-primary w-100 m-2">
			<a href="/" class="btn btn-primary w-100 m-2">이전으로</a>
			<input type="hidden" name=flag value=true>
		</form>
	</div>
</body>
</html>