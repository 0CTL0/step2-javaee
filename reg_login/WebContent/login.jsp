<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.imooc.utils.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div class="login">
        <div class="header">
            <h1>
                <a href="./login.jsp">登录</a> <a href="./regist.jsp">注册</a>
            </h1>
		<%	
		String username="";
		
		//获取从客户客户端携带过过来的所有Cookie
		Cookie[] cookies=request.getCookies();
		//从Cookie的数组中查找指定名称的Cookie
		Cookie cookie=CookieUtils.findCookie(cookies,"username");
		if(cookie!=null){
			username=cookie.getValue();
		}
		//获取注册后自动获取注册的用户名,如何session有，就把cookie的用户名覆盖掉
		if(session.getAttribute("username")!=null){
			username=(String)session.getAttribute("username");
		}
		
		//获取登录失败的提示信息
		String msg="";
		if(request.getAttribute("msg")!=null){
			msg=(String)request.getAttribute("msg");
		}
	
		%>
		<h3><font color="red"><%=msg%></font></h3>
		
        </div>
        <form action="/reg_login/LoginServlet" method="post">
            <table>
                <tr>
                    <td class="td1">用户名</td>
                    <td><input type="text" class="input1" name="username" vlaue="<%=username%>"></td>
                </tr>
                <tr>
                <td class="td1">密码</td>
                <td><input type="password" class="input1" name="password"></td>
                </tr>
                <tr>
                <td class="td1" colspan="2">
                    <input type="checkbox" name="remember" value="true" checked="checked"> 记住用户名</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="btn-red">
                            <input type="submit" value="登录" id="login-btn">
                        </div>
                    </td>
                </tr>
            </table>

        </form>
    </div>
</body>
</html>