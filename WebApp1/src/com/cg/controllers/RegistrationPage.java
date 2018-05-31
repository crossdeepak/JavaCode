package com.cg.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String filePath;
	public void init(ServletConfig config) throws ServletException {
		filePath = getServletContext().getInitParameter("resumeFile");
	}

	public void destroy() {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("response()");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		String gender=request.getParameter("gender");
		String [] communication=request.getParameterValues("communication");
		String graduation=request.getParameter("graduation");
		String enterDetails=request.getParameter("enterDetails");
		String resumeFile=request.getParameter("resumeFile");
		RequestDispatcher dispatcher;
		/*File file=new File(resumeFile);
		FileInputStream src=new FileInputStream(file);
		String path=file.getAbsolutePath();
		String finalPath="\""+path+"\"";
		System.out.println(finalPath);
		byte [] dataBuffer=new byte[(int)file.length()];
		src.read(dataBuffer);
		String res1=new String(dataBuffer);*/
		System.out.println(resumeFile);
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		if(password.equals(password1)){
		out.println("<p>First Name : "+firstName);
		out.println("<p>Last Name : "+lastName);
		out.println("<p>Gender : "+gender);
		System.out.println("<p>Mode Of Communication is:");
		for(int i=0;i<communication.length;i++)
		out.println(communication[i]);
		out.println("<p>Graduation : "+graduation);
		out.println("<p>Enter Details : "+enterDetails);
		}
		else{
			out.println("<p>Passwords Do Not Match</p>");
		}
		out.println("</div>");
		out.println("<body>");
		out.println("</html>");
	}
}
