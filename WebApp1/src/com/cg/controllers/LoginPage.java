package com.cg.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}
	public void destroy() {
		System.out.println("destroy()");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("response()");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(userName.equals("sasasasa") && password.equals("helloworld")){
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		out.println("<font align='center' color='green'>Login Successful</font>");
		out.println("</div>");
		out.println("<body>");
		out.println("</html>");
		}
		else{
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div>");
			out.println("<font align='center' color='red'>Login Unsucessful</font>");
			out.println("</div>");
			out.println("<body>");
			out.println("</html>");
		}
	}
}
