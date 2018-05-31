package com.cg.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int i=0;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}
	public void destroy() {
		System.out.println("destroy()");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		i++;
		System.out.println("response()");
		if(i<3){
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		out.println("<font align='center' color='olive' size=12>CrossFire : Hello World</font>");
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
			out.println("<font align='center' color='green' size=12>CrossFire : Hello World</font>");
			out.println("</div>");
			out.println("<body>");
			out.println("</html>");
		}
	}

}
