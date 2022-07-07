<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<style>
			#topmenu ul{ list-style:none; padding:0px;}
			#topmenu li{width:80px; text-align:right;}
			#topmenu a{text-decoration:none; color:black;}
		</style>
		<div id=topmenu>
			<ul style="display:flex;flex-direction:row-reverse">
				<li><a href="/Logout.do">로그아웃</a></li>
				<li><a href="/MemberInfo.do">나의정보</a></li>
			</ul>
		</div>
</body>
</html>