<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.io.*" %>
<%
   File dir = new File("c://upload");  //파일클래스 만든다 업로드 경로 연결 시킨다
   File [] files = dir.listFiles(); // 파일명 가져온다 절대경로로 가져온다
   for(int i=0; i<files.length; i++){
	  out.println("<a href=/download.do?filename="+files[i].getName().replaceAll(" ","+")+">"+files[i].getName()+"</a><br>");
   }  //getName 으로 a태크 링크 설정 해서  파일에 공백이 있으면 짤림 그래서 작업한다
%>

</body>
</html>
