package com.imooc.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	
	//监听添加的域对象属性
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("ServletContext#attAdded#name:" + scae.getName() + "#value:"	+ scae.getValue());

	}

	//监听移除的域对象属性
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("ServletContext#attRemoved#name:" + scae.getName() + "#value:"	+ scae.getValue());

	}
	
	//监听替换的域对象属性
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("ServletContext#attReplaced#name:" + scae.getName() + "#value:"	+ scae.getValue());

	}

}
