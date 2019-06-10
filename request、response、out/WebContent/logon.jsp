<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">人事管理系统登录页面</h3>
	<hr>
	<!-- action代表了服务器端的处理程序 ,可以是一个servet，也可以是一个jsp-->
	<form action="">
		<table>
			<tr>
				<td>
					账号：
				</td>
				<td>
					<input type="text" name="account"/>
				</td>
			</tr>
			<tr>
				<td>
					密码：
				</td>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="登录"/>
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>