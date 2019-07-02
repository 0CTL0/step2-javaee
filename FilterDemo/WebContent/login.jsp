<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//模拟登录操作，在session中存入登录用户的用户名
		session.setAttribute("loginUser", username);		
		//重定向至留言板页面
			//这里理解吧，访问成功就重定向，不成功就转发请求
		response.sendRedirect(request.getContextPath()+"/message.jsp");
%>