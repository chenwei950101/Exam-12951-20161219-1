package com.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

public class LogoutServlet18 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogoutServlet18() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
             req.getSession().invalidate();
             resp.sendRedirect(req.getContextPath()+"/18/index.jsp");
	}
	

}
