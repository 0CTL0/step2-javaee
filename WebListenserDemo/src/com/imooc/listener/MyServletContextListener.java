package com.imooc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

		//ServletContextEvent封装了context对象及其他所有的相关信息
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//获取配置信息的参数
		String appName=(String)sce.getServletContext().getInitParameter("app_name");
		String version=(String)sce.getServletContext().getInitParameter("version");
		System.out.println(appName+"  destroy! "+version);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//获取配置信息的参数
		String appName=sce.getServletContext().getInitParameter("app_name");
		String version=sce.getServletContext().getInitParameter("version");
		System.out.println(appName+" init! "+version);
	}

	
}
