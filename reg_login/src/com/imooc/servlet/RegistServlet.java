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
 * �û�ע���Servlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ݵĽ���
		//��upload��API������,�ṩ��������ַ�����		
		try {
			//����һ��Map�������洢���յ�����
			Map<String,String> map=new HashMap<String,String>();
			
			//1������һ�������ļ��������
			DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
			//2������һ�����Ľ�����
			ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
			//3������request���󣬷��ص���List���ϣ�List�����д�ŵ���FileItem����
			List<FileItem> list=servletFileUpload.parseRequest(request);
			//����һ��List���ϣ����ڱ��渴ѡ�����Ȥ��������    ��Ϊ��Ȥ���Ƕ��������Ҫ�������洢
			List<String> hobbyList=new ArrayList<String>();
			//4���������ϣ����ÿ��FileItem���ж��Ǳ�������ļ��ϴ���
			String url=null;
			for(FileItem fileItem:list) {
				if(fileItem.isFormField()) {
					//��ͨ�����
					String name=fileItem.getFieldName();  //��ñ������name���Ե�ֵ
					String value=fileItem.getString("utf-8");  //��ñ������ֵ
					System.out.println(name+"	"+value);
					//���ո�ѡ�������
					if("hobby".equals(name)) {
						String hobbyValue=fileItem.getString("UTF-8");
						//���յ�һ��ֵ�������ֵ���뵽hobbyList������
						hobbyList.add(hobbyValue);
						//ȥ���������ҵ�����
						hobbyValue=hobbyList.toString().substring(1, hobbyList.toString().length()-1);
						System.out.println(name+"	"+hobbyValue);
						//�����õ����ݴ��뵽Map������
						map.put(name,hobbyValue);
					}else {
						//�����ݴ��뵽map������
						map.put(name,value);
					}		
				}
				else {
					//�ļ��ϴ���:�����ϴ�������������ȥ��Ҳ�����ϴ���Ӳ�̵��С�
					/*
					 * �����ϴ����ù��̵�upLoadĿ¼�£��ϴ���ֱ���ڹ����п�������
					 * Ҫ��tomcatĿ¼�·����Ĺ����п������ֿ����ع��̺ͷ������������Ĺ��̣�
					 * ���ʶ���ֻ�й���Ŀ¼�µ�ͼƬ�����ϴ��ɹ�������Ĳ��У�
					 */			
					//�ļ��ϴ�����:
					//����ļ��ϴ������ƣ�
					String fileName=fileItem.getName();
					//��һ���жϣ������û�û���ϴ��ļ�����ִ���쳣��
						//�����ڿգ�Ҳ�����ڿյ��ַ���
					if(fileName!=null && !"".equals(fileName)) {
						//ͨ����������Ψһ�ļ�����
						String uuidFileName=UploadUtils.getUUIDFileName(fileName);					
						//����ļ��ϴ������ݣ�
						InputStream is=fileItem.getInputStream();
						//����ļ��ϴ���·����
						String path=this.getServletContext().getRealPath("/upload");
						//���������Խӵ�������ӿ����ˣ�
						url=path+"\\"+uuidFileName;
						OutputStream os=new FileOutputStream(url);
						int len=0;
						byte[] b=new byte[1024];
							//������������
						while((len=is.read(b))!=-1) {
							os.write(b,0,len);
						}
						is.close();
						os.close();						
					}				
				}
			}
			System.out.println(map);
			//��ע���û�����Ϣ���뵽֮ǰ��ʼ��ʱ��List������
			List<User> userList=(List<User>)this.getServletContext().getAttribute("list");
			//�Ӽ�����У���û�����
			for(User u:userList) {
				if(u.getUsername().equals(map.get("username"))) {
					request.setAttribute("msg", "�û����Ѿ����ڣ�");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
			}	
			//��װ���ݵ�User���У�
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
			//���ʣ�ȡ�����ַŽ�ȥ��ͬ���ͻḲ�ǹ��̶������������
			this.getServletContext().setAttribute("list", userList);
			
			//��ע�����û���Ĭ����д����¼��
			request.getSession().setAttribute("username", user.getUsername());
			//ע��ɹ�����ת����¼ҳ�棺һ�����ض���Ϊɶ�أ���Ϊ��Ӧ���󣬴���ʹ�ðɡ�
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