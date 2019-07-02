<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.*" %>

<%--这个老师，将jsp数据又提交到jsp文件，完全不遵循MVC开发模式 --%>
<%--jsp文件也可以新建javaBean对象 --%>
<% 
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Message message = new Message();
	message.setTitle(title);
	message.setContent(content);
	
	List<Message> messages = (List<Message>)session.getAttribute("messages");
	if(messages == null){
		messages = new ArrayList<Message>();
		session.setAttribute("messages", messages);
	}
	
	messages.add(message);//留言列表信息存储至session中
	
	response.sendRedirect(request.getContextPath()+"/message.jsp?subFlag=1");//重定向至留言板页面
%>