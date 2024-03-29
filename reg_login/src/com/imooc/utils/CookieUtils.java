package com.imooc.utils;

import javax.servlet.http.Cookie;

//Cookie查找的工具类
public class CookieUtils {
	//定义类的数组！
		//定义为静态方法，无需实例化，直接调用。
	public static Cookie findCookie(Cookie[] cookies,String name) {
		if(cookies==null) {
			//说明浏览器没有携带Cookie；
			return null;
		}
		else {
			//携带Cookie
			for(Cookie cookie:cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
			return null;
		}
	}
}
