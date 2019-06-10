<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--
	上下两句效果等同！
	<%=pageContext.getRequest().getParameter("name") %>
	  -->
	<%=request.getParameter("name") %>
	
</body>
</html>