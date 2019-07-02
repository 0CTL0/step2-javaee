package com.imooc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request listener,request destroyed... ...");

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		
		//获得请求的路径
		String path = request.getRequestURI();
		//获取request作用域的参数值
		String par = request.getParameter("par");

		System.out.println("request listener,path:" + path + ",par is :" + par);

	}

}
