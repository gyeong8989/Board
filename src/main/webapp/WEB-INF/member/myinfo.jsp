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
	<%@page import="com.korea.dto.MemberDTO" %>
	<%
		MemberDTO dto = (MemberDTO)request.getAttribute("dto");
	%>
	
	

	<div class="container-md" id=wrapper style="width:80%;margin:100px auto;">
		<!-- TopMenu -->
		<%@include file="/resources/includes/topmenu.jsp" %>
		
		<!-- NAV  -->
		<%@include file="/resources/includes/nav.jsp" %>
		
		<!-- MainContents -->
		<div id=maincontents style="border: 1px solid gray;margin-top:15px;">
			
			<table class="table w-75">
				<tr>
					<td>Email</td>
					<td><%=dto.getEmail() %></td>
				</tr>
				<tr>
					<td>Addr1</td>
					<td><%=dto.getAddr1() %></td>
				</tr>
				<tr>
					<td>Addr2</td>
					<td><%=dto.getAddr2() %></td>
				</tr>
				<tr>
					<td colspan=2>
						<td>
						<button class="btn btn-primary w-50">정보수정</button>
						</td>
						<td>
						<button class="btn btn-secondary w-50">메인이동</button>
						</td>
					</td>
				</tr>
			</table>
		</div>
		
		<!-- Footer  -->
	
	</div>
</body>
</html>