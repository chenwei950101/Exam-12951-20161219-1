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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		String return_uri=req.getParameter("return_uri");
		System.out.println("�û�����"+userName);
		System.out.println("���룺"+password);
		System.out.println("return_url:"+return_uri);
		
		RequestDispatcher rd=null;
		if(userName==null||password==null){
			req.setAttribute("msg", "�û��������벻��Ϊ��");
			rd=req.getRequestDispatcher("/18/login.jsp");
			rd.forward(req, resp);
		}else{
			if(userName.equals("��ΰ")&&password.equals("1234")){
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
				req.setAttribute("msg", "�û����������������");
				rd=req.getRequestDispatcher("/18/login.jsp");
				rd.forward(req, resp);
				
			}
			
		}
	
	}

}
