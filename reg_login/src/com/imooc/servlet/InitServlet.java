package com.imooc.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.imooc.domain.User;

/**
 * 用户注册的初始化的Servlet
 * 如何实现服务器一启动，就实例化该类呢？
 * 答：到web.xml中配置。
 */
public class InitServlet extends HttpServlet {

	//该重写方法在第一次访问时执行
	@Override
	public void init() throws ServletException {
		//创建一个List集合用户保存用户注册的信息
		List<User> list=new ArrayList<User>();
		//将List保存到ServletContext作用域
			//工程对象，生命周期跟tomcat一致
		this.getServletContext().setAttribute("list", list);
	}
	
	

}
