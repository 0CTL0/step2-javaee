<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSTL常用标签</title>
</head>

<body>

	<!-- set out remove标签 -->
	<c:set var="user" value="张三" scope="request"></c:set><br>
	<c:out value="${user}"></c:out>
	<c:remove var="user" scope="request"/>
	<c:out value="${user}"></c:out>
	
	<!-- if、choose条件标签 -->
	<c:set var="age" value="13" scope="request"></c:set>
	<c:if test="${age==12}">
		你的年龄为12岁
	</c:if>
	<br>hello world!
	<br>
	<c:choose>
		<c:when test="${age==12}">
		你的年龄为12岁
		</c:when>
		<c:otherwise>
		你的年龄不为12岁
		</c:otherwise>
	</c:choose>
	
	<!-- 迭代标签 -->
	
</body>
</html>