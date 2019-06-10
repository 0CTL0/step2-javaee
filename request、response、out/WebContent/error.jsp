<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    <%--isErrorPage="true"声明为异常页面，才可以使用异常对象 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	1、exception对象只能在错误页面使用，page中加入一个属性isErrorPage="true"
	2、如果页面中出现了异常，在页面中通过errorage来指定错误处理页面。
	 -->
	<%=exception.getMessage() %>
</body>
</html>