<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	String str="hello world";
	String getStr(){
		return"hello world2";
		}
%>
	<hr>
	<% out.println(this.str);%>
	<hr>
	<% out.println(this.getStr());%>
	<hr>
	<%=this.getStr()%>
</body>
</html>