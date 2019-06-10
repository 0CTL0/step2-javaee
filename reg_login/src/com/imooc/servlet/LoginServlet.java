package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;

/**
 * �û���¼��Servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������ݣ�
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//��ServletContext���л�ñ����û���Ϣ���ϣ�
		List<User> list=(List<User>)this.getServletContext().getAttribute("list");
		for(User user:list) {
			//�ж��û����Ƿ���ȷ
			if(username.equals(user.getUsername())) {
				//�û�����ȷ
				if(password.equals(user.getPassword())) {
					//����Ҳ��ȷ
					//��¼�ɹ���
					
					//�жϸ�ѡ���Ƿ񱻹�ѡ��
					String remember=request.getParameter("remember");
					if("true".equals(remember)) {
						//��ס�û����Ĺ��ܣ�
						Cookie cookie=new Cookie("username",user.getUsername());
						//����cookie��Ч·����ʱ�䣺
						cookie.setPath("/reg_login");
						cookie.setMaxAge(60*60*24);  //����24Сʱ
						//��cookie��д���������
						response.addCookie(cookie);
					}
					
					//���û�����Ϣ����Session��
					request.getSession().setAttribute("user", user);
					response.sendRedirect("/reg_login/success.jsp");
					return;
				}
			}
		}
		//��¼ʧ�ܣ�����⣻�ɹ������ض���ʧ�ܾ�ת������
		request.setAttribute("msg", "�û��������");
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
