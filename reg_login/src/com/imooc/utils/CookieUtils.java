package com.imooc.utils;

import javax.servlet.http.Cookie;

//Cookie���ҵĹ�����
public class CookieUtils {
	//����������飡
	public static Cookie findCookie(Cookie[] cookies,String name) {
		if(cookies==null) {
			//˵�������û��Я��Cookie��
			return null;
		}
		else {
			//Я��Cookie
			for(Cookie cookie:cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
			return null;
		}
	}
}