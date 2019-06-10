package com.imooc.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.imooc.domain.User;

/**
 * �û�ע��ĳ�ʼ����Servlet
 * ���ʵ�ַ�����һ��������ʵ���������أ�
 * �𣺵�web.xml�����á�
 */
public class InitServlet extends HttpServlet {

	//����д�����ڵ�һ�η���ʱִ��
	@Override
	public void init() throws ServletException {
		//����һ��List�����û������û�ע�����Ϣ
		List<User> list=new ArrayList<User>();
		//��List���浽ServletContext������
			//���̶����������ڸ�tomcatһ��
		this.getServletContext().setAttribute("list", list);
	}
	
	

}