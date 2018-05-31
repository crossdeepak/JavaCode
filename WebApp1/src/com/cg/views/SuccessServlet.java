package com.cg.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.UserBean;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean=(UserBean) request.getAttribute("userBean");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		out.println("<p><font align='center' color='green'>Login SuccessFul</font>");
		out.println("<p>Welcome "+userBean.getUserName()+" to your login page");
		out.println("</div>");
		out.println("<body>");
		out.println("</html>");
		
	}

}
