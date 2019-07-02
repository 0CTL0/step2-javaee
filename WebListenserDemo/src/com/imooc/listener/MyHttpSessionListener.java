package com.imooc.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	
	//HttpSessionEvent对象封装着session及所有的相关信息
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		//通过session事件可以获取session对象
		String sessionId = hse.getSession().getId();
		Date createTime = new Date(hse.getSession().getCreationTime());
		
		System.out.println("session id:"+sessionId+",createTime:"+createTime);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		String sessionId = hse.getSession().getId();
		System.out.println("session destroyed,session id:"+sessionId);

	}

}
