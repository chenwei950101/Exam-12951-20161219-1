package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet18 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet18() {
		
	}


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String first_Name=req.getParameter("first_Name");
		String return_uri=req.getParameter("return_uri");
		System.out.println("用户名："+first_Name);
		System.out.println("return_url:"+return_uri);
		
		RequestDispatcher rd=null;
		if(first_Name==null){
			req.setAttribute("msg", "用户名不能为空");
			rd=req.getRequestDispatcher("/18/login.jsp");
			rd.forward(req, resp);
		}else{
			if(first_Name.equals("MARY")){
				req.getSession().setAttribute("flag", "login_success");
				if(return_uri!=null){
					rd=req.getRequestDispatcher("return_uri");
					rd.forward(req, resp);
				}else{
					rd=req.getRequestDispatcher("/18/index.jsp");
					rd.forward(req, resp);
				}
			}else{
				req.getSession().setAttribute("flag", "login_error");
				req.setAttribute("msg", "用户名输入错误");
				rd=req.getRequestDispatcher("/18/login.jsp");
				rd.forward(req, resp);
				
			}
			
		}
	
	}

}
