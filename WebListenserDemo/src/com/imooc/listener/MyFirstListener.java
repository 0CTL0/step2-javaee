package com.imooc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyFirstListener implements ServletContextListener {

	//ServletContext跟application内置对象一样，指web工程。
		//context指环境，上下文
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Context对象销毁时（工程移除），触发该方法
		System.out.println("context  destroy!");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Context对象初始化时（工程启动），触发该方法
		System.out.println("context  init!");
	}

	
}
