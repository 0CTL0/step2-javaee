package com.imooc.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imooc.domain.User;
import com.imooc.utils.UploadUtils;

/**
 * 用户注册的Servlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//数据的接收
		//用upload的API来操作,提供各种类各种方法：		
		try {
			//定义一个Map集合来存储接收的数据
			Map<String,String> map=new HashMap<String,String>();
			
			//1、创建一个磁盘文件项工厂对象
			DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
			//2、创建一个核心解析类
			ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
			//3、解析request请求，返回的是List集合，List集合中存放的是FileItem对象
			List<FileItem> list=servletFileUpload.parseRequest(request);
			//定义一个List集合，用于保存复选框的兴趣爱好数据    因为兴趣项是多个对象，需要数组来存储
			List<String> hobbyList=new ArrayList<String>();
			//4、遍历集合，获得每个FileItem，判断是表单项还是文件上传项
			String url=null;
			for(FileItem fileItem:list) {
				if(fileItem.isFormField()) {
					//普通表单项：
					String name=fileItem.getFieldName();  //获得表单项的name属性的值
					String value=fileItem.getString("utf-8");  //获得表单项的值
					System.out.println(name+"	"+value);
					//接收复选框的数据
					if("hobby".equals(name)) {
						String hobbyValue=fileItem.getString("UTF-8");
						//接收到一个值，将这个值存入到hobbyList集合中
						hobbyList.add(hobbyValue);
						//去除数据左右的括号
						hobbyValue=hobbyList.toString().substring(1, hobbyList.toString().length()-1);
						System.out.println(name+"	"+hobbyValue);
						//将爱好的数据存入到Map集合中
						map.put(name,hobbyValue);
					}else {
						//将数据存入到map集合中
						map.put(name,value);
					}		
				}
				else {
					//文件上传项:可以上传到服务器当中去，也可以上传到硬盘当中。
					/*
					 * 这里上传到该工程的upLoad目录下，上传后直接在工程中看不到，
					 * 要到tomcat目录下发布的工程中看。区分开本地工程和发布到服务器的工程！
					 * 疑问二：只有工程目录下的图片可以上传成功，桌面的不行？
					 */			
					//文件上传功能:
					//获得文件上传的名称：
					String fileName=fileItem.getName();
					//做一个判断，限制用户没用上传文件导致执行异常：
						//不等于空，也不等于空的字符串
					if(fileName!=null && !"".equals(fileName)) {
						//通过工具类获得唯一文件名；
						String uuidFileName=UploadUtils.getUUIDFileName(fileName);					
						//获得文件上传的数据：
						InputStream is=fileItem.getInputStream();
						//获得文件上传的路径：
						String path=this.getServletContext().getRealPath("/upload");
						//将输入流对接到输出流接可以了：
						url=path+"\\"+uuidFileName;
						OutputStream os=new FileOutputStream(url);
						int len=0;
						byte[] b=new byte[1024];
							//这里又忘记了
						while((len=is.read(b))!=-1) {
							os.write(b,0,len);
						}
						is.close();
						os.close();						
					}				
				}
			}
			System.out.println(map);
			//将注册用户的信息存入到之前初始化时的List集合中
			List<User> userList=(List<User>)this.getServletContext().getAttribute("list");
			//从集合中校验用户名：
			for(User u:userList) {
				if(u.getUsername().equals(map.get("username"))) {
					request.setAttribute("msg", "用户名已经存在！");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
			}	
			//封装数据到User当中：
			User user=new User();
			user.setUsername(map.get("username"));
			user.setPassword(map.get("password"));
			user.setSex(map.get("sex"));
			user.setNickname(map.get("nickname"));
			user.setHobby(map.get("hobby"));
			user.setPath(url);
			
			userList.add(user);
			for(User u:userList) {
				System.out.println(u);
			}
			//疑问：取出后又放进去，同名就会覆盖工程对象域的数据吗？
			this.getServletContext().setAttribute("list", userList);
			
			//把注册后的用户名默认填写到登录框
			request.getSession().setAttribute("username", user.getUsername());
			//注册成功，跳转到登录页面：一般用重定向，为啥呢？作为回应对象，搭配使用吧。
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
