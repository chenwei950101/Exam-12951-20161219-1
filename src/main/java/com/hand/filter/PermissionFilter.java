package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter{
	
	public void init(FilterConfig fconfig) throws ServletException {
		
	}


	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		String servletPath=request.getServletPath();
		HttpSession session=request.getSession();
		String flag=(String) session.getAttribute("flag");
		if(servletPath!=null&&servletPath.equals("/18/index.jsp")||
				servletPath.equals("/18/login.jsp")||servletPath.equals("/LoginServlet18")){
		chain.doFilter(req, resp);	
	}else{
		if(flag!=null&&flag.equals("login_success")){
			chain.doFilter(req, resp);	
		}else if(flag!=null&&flag.equals("login_error")){
			req.setAttribute("msg", "登录失败请重新登录</br>");
			req.setAttribute("return_url", servletPath);
			RequestDispatcher rd=req.getRequestDispatcher("/18/login.jsp");
			rd.forward(request, response);
		}else{
			req.setAttribute("msg", "您尚未登录");
			req.setAttribute("return_url", servletPath);
			RequestDispatcher rd=req.getRequestDispatcher("/18/login.jsp");
			rd.forward(request, response);
		}
	}
		}

	public void destroy() {
		
	}


}
