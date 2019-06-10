<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"
    pageEncoding="UTF-8" import="com.imooc.db.*,com.imooc.bean.*,java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- 获取账号以及密码，并且需要去调用DBUtil当中的方法来判断是否存在指定的信息 
		1、如果正确，DBUtil方法返回的值是true，显示成功页面
		2、如果错误，false，显示错误消息
		
		request：获取请求信息，包括请求信息。
		getParameter(String name):可以通过一个html控件的name属性来获取控件的值		
		request.setAtribute("name","Imooc");  
		//把数据放入requst作用域：为request对象设置属性，request对象不是静态的，此时其他页面仍不能使用该属性。
		request.getRequestDispatcher("result.jsp".forward(request,respnse);
		//转发请求：把当前页面的request、reponse对象转发到result.jsp，就可以使用该属性了。
				
		out:输出流对象，输出指定的信息。
		println();
		
		reponse提供大量的方法和API，供我们使用。
	-->
	<h3 align="center">响应的字符编码集：<%= response.getCharacterEncoding() %></h3>
	
	<%
		String account = request.getParameter("account");
	
		String password = request.getParameter("password");
		
		Emp emp = new Emp(account,null,password,null);
		boolean flag = DBUtil.selectEmpByAccountAndPassword(emp);
		Map<String,Emp> map = DBUtil.map;
		if(flag == true){
			%>
			<!-- 获取访问量count, 如果系统第一次登陆，则创建访问量
			下面的1是什么？也是object?
			答：发生了自动装箱。
			-->
			<% 
			Object o = application.getAttribute("count");
			if(o == null){
				application.setAttribute("count", 1);
				
			}else{
				int count = Integer.parseInt(o.toString());
				application.setAttribute("count", count + 1);
				
			}
			
			session.setAttribute("account", account);
	%>
	<!-- JSP不需使用<<<EOF,直接把html代码写在里面！用分隔符<%%>隔开就行！ -->
	
			<h3 align="right">访问量：<%= application.getAttribute("count") %></h3>
			<h3 align="right">登录账户：<%= session.getAttribute("account") %></h3>
			<h3 align="center">欢迎来到人事管理系统的首页</h3>
			<hr>
			<table align="center" border="1" width="500px">
				<tr>
					<td>
						账号
					</td>
					<td>
						员工姓名
					</td>
					<td>
						邮箱
					</td>
					<td>
						修改
					</td>
				</tr>
				<%
					for(String key : map.keySet()){
						Emp e = map.get(key);
						%>
							<tr>
								<td>
					
									<%= e.getAccount() %>
								</td>
								<td>
									<%= e.getName() %>
								</td>
								<td>
									<%= e.getEmail() %>
								</td>
								<td>
									<!-- 
									相邻两个JSP页面传递数据的时候。通过URL参数的方式来传递数据。
									规则：
									资源?key=value&key=value
									 -->
									<a href="update.jsp?account=<%= e.getAccount() %>&name=<%= e.getName() %>&email=<%= e.getEmail() %>">修改</a>
								</td>
							</tr>
						<%
					}
				%>
			</table>
	<%
		}else{			
			throw new Exception("账号和密码错误");
		}
	%>
	<%--习惯抛出异常对象来处理错误，在上面errorPage="error.jsp"指明处理异常的程序--%>
</body>
</html>