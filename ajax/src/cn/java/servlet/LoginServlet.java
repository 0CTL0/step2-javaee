package cn.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//AJAX请求也是使用request对象来获取json格式数据
		
		//1、首先获取jsp页面传递过来的参数信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2、如果username="15912345678"，password="12345678"则登录成功，否则登录失败
		
		JSONObject jsonObject = null;
		if("15912345678".equals(username) && "12345678".equals(password)){
			System.out.println("username="+username);
			System.out.println("password="+password);
			jsonObject = new JSONObject("{flag:true}");
		}else{
			//如果登录失败，则给ajax返回数据
			jsonObject = new JSONObject("{flag:false}");
		}
		
		//通过reponse中的一个方法回写给AJAX
		//将json数据转换为字节数组，并设置字符编码
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
