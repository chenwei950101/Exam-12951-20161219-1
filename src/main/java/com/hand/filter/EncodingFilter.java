package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String charEcoding;
	public EncodingFilter() {
		
	}
	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		charEcoding=fconfig.getInitParameter("encoding");
		if(charEcoding==null){
			throw new ServletException("EncodingFilter中的设置编码为空");
		
		}
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		if(!charEcoding.equals(req.getCharacterEncoding())){
			req.setCharacterEncoding(charEcoding);
		}
		resp.setCharacterEncoding(charEcoding);
		chain.doFilter(req, resp);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
