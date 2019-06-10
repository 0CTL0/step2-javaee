<%@page import="com.imooc.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<!-- 不同：html标签选择执行是嵌套在JSP标签之间当中，php则是直接在代码中输出，百分号>html代码<百分号可以理解为<<<EOF-->
	<%
		if(session.getAttribute("user")!=null){	
			User user=(User)session.getAttribute("user");
			System.out.println(user.getPath());
			/*
			这里的意思是，getpath获取的上传图片存储到磁盘的绝对路径，需要更改为工程的路径。
			(理：工程路径是相对路径，用/代替webContent所在的绝对路径,在项目中统一用工程路径)
			???数据上传获取没问题，为什么无法显示出头像？推测：跳转页面后，上传的图片被tomcat清楚掉了，没有保存。
			*/		
			//获得图片绝对路径最后一个\的位置
			int idx=user.getPath().lastIndexOf("\\");
			//获取文件上传的唯一文件名：
			String fileName=user.getPath().substring(idx+1);
			System.out.println(fileName);
	%>
	
	<div class="login">
		<div class="header">
			<h1>登录成功</h1>
		</div>
		<div class="content">
			<table align="center">
				<tr>
					<td align="center"><img src="/reg_login/upLoad/<%=fileName %>" /></td>
				</tr>
				<tr>
					<td align="center">欢迎<%=user.getNickname() %>,登录成功！</td>
				</tr>
			</table>

		</div>
	</div>	
	<%
		}else{
	%>
	<div class="login">
		<div class="header">
		<h1>你还没有登录！请先去<a href="/reg_login/login.jsp">登录</a>！</h1>
		</div>
	</div>
	
	<%		
		}
	%>
	
</body>
</html>