package com.imooc.cache;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/**
 * 登录用户与session缓存对象
 * @author lv
 *
 */

//单例模式：一个类有且仅有一个实例；自行实例化；自行向整个系统提供。
public class LoginCache {
	
	private static LoginCache instance = new LoginCache();
	
	//HttpSession对象在创建后，都会有一个唯一的ID用于与其他的session做标志区别。
	//3.0的servlet  api版本中不支持直接通过sessionId获得Session对象。
	
	/*
	 * 关于此处为什么不将用户名和session关联？
	 * 如例1：当系统复杂起来，用户某种原因不断进行登录退出操作，可用sessionID来决定session对象是否需要创建销毁。
	 */
	// key值：登录用户登录名，value值：登录用户sessionId
	private Map<String,String> loginUserSession = new HashMap<String,String>();
	//key值:登录用户sessionId,value值：登录用户session对象
	private Map<String,HttpSession> loginSession = new HashMap<String,HttpSession>();
	
	
	private LoginCache(){
		
	}
	
	public static LoginCache getInstance(){
		return instance;
	}
	
	/**
	 * 封装一个方法：
	 * 通过登录名获取对应登录用户的sessionId
	 * @param username
	 * @return
	 */
	public String getSessionIdByUsername(String username){
		return loginUserSession.get(username);
	}
	
	/**
	 * 通过sessionId获取对应的session对象
	 * @param sessionId
	 * @return
	 */
	public HttpSession getSessionBySessionId(String sessionId){
		return loginSession.get(sessionId);
	}
	
	
	/**
	 * 存储登录名与对应的登录sessionID至缓存对象
	 * @param username
	 * @param sessionId
	 */
	public void setSessionIdByUserName(String username,String sessionId){
		loginUserSession.put(username, sessionId);
	}
	
	/**
	 * 存储sessionId与对应的session对象至缓存对象
	 * @param sessionId
	 * @param session
	 */
	public void setSessionBySessionId(String sessionId,HttpSession session){
		loginSession.put(sessionId, session);
	}
}
