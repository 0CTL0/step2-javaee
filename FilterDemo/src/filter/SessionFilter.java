package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SessionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 涉及到HTTP请求处理，转型处理。
		//（说明过滤器也能处理其他类型servlet请求？）
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;//涉及到HTTP请求处理，转型处理
		// 判断用户是否完成了登录操作，session中是否存储用户名
		String loginUser = (String) hrequest.getSession().getAttribute("loginUser");
		// 未登录，系统强制重定向至登录页面
		if (loginUser == null) {
			hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?flag=1");
			return;
		} else {
			chain.doFilter(hrequest, hresponse);
			return;
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
