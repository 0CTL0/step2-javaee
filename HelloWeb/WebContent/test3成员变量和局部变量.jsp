<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--定义成员变量和局部变量 --%>
<%!int totalCount=0; %>
<%int localCount=0;
	totalCount++;
	localCount++;
	%>
<%--成员变量每刷新一次就递增一次，为什么？ --%>
<%--局部变量每次都重新开始 --%>
<%
	out.println(totalCount);
	out.println("<br>");
	out.println(localCount);
%>
</body>
</html>