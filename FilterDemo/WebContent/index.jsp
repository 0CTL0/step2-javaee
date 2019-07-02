<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String flag = request.getParameter("flag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
<link href="form.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
    var flag = '<%=flag %>';
    if("1"==flag){
    	alert("è¯·ç»å½ç³»ç»ï¼");
    }
</script>
</head>

<!-- 启动tomcat后，每次修改保存eclipse项目，都会自动移除重新部署项目 -->
<!-- 登录成功后跳转到留言板 -->
<body>
  <form action="login.jsp" method="post" class="smart-green">
	<h1>系统登录</h1>

	<label>
	<span>用户名：</span>
	<input id="username" type="text" name="username"/>
	</label>

	<label>
	<span>密码：</span>
	<input id="password" type="password" name="password"/>
	</label>

	<span>&nbsp;</span>

	<label>
	<input type="submit" class="button" value="登录"/>
	</label>
	
  </form>
</body>
</html>