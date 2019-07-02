package filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 处理中文编码问题的过滤器
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig config;

	//初始化函数
	@Override
	public void init(FilterConfig config) throws ServletException {
		//接收web.xml中filter的配置信息对象
		this.config = config;
		//初始化操作
		System.out.println("characterEncodingFilter init!");
	}

	//一般修改数据时都是直接修改文本文件，下面这两个函数很少用
	public FilterConfig getConfig() {
		return config;
	}
	public void setConfig(FilterConfig config) {
		this.config = config;
	}

	
	/*
	 * 参数：获取预处理和后处理的request和response对象，
	 * 		chain参数对象中的doFilter方法通知服务器预处理完成。
	 */
	//调用过滤器的主操作函数
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取在web.xml中自定义的配置信息
//		 System.out.println("characterEncodingFilter doFilter!");
//		 String systemName=config.getInitParameter("systemName");
//		 String version=config.getInitParameter("version");
//		 System.out.println("systemName:"+systemName+"version:"+version);
		 
		//拦截请求，设置其的字符编码。获取配置文件的数据，方便后期维护。
		request.setCharacterEncoding(config.getInitParameter("charset2"));
		chain.doFilter(request, response);
	}
	
	
	//过滤器销毁时调用该函数
	@Override
	public void destroy() {
//		System.out.println("characterEncodingFilter destroy!");
	}

	



}
