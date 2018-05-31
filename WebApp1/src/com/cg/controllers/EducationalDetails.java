package com.cg.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EducationalDetails")
public class EducationalDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String schoolName = request.getParameter("schoolName");
		String percentage = request.getParameter("percentage");
		String pic = request.getParameter("pic");
		String resumeFileToUpload = request.getParameter("resumeFileToUpload");
		String grade = request.getParameter("grade");
		String schoolName2 = request.getParameter("schoolName2");
		String percentage2 = request.getParameter("percentage2");
		String grade2 = request.getParameter("grade2");
		String qualification3 = request.getParameter("qualification3");
		String instituteName3 = request.getParameter("instituteName3");
		String percentage3 = request.getParameter("percentage3");
		String grade3 = request.getParameter("grade3");
		String qualification4 = request.getParameter("qualification4");
		String instituteName4 = request.getParameter("instituteName4");
		String percentage4 = request.getParameter("percentage4");
		String grade4 = request.getParameter("grade4");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div >");
		writer.println("<p>FirstName is:"+firstName+"</p>"); 
		writer.println("<p>LastName is:"+lastName); 
		writer.println("<br />");
		writer.println("<p>Your 10th Details are");
		writer.println("<p>SchoolName is:"+schoolName+" Percentage is:"+percentage+" Grade is:"+grade);
//		writer.println("<p>Percentage is:"+perc);
//		writer.println("<p>Grade is:"+grade); 
		writer.println("<br />");
		writer.println("<p>Your 12th Details are");
		writer.println("<p>SchoolName is:"+schoolName2);
		writer.println("<p>Percentage is:"+percentage2);
		writer.println("<p>Grade is:"+grade2);
		writer.println("<br />");
		writer.println("<p>Your UG Details are");
		writer.println("<p>Qualification is:"+qualification3);
		writer.println("<p>SchoolName is:"+instituteName3);
		writer.println("<p>Percentage is:"+percentage3);
		writer.println("<p>Grade is:"+grade3); 
		writer.println("<br />");
		writer.println("<p>Your PG Details are");
		writer.println("<p>Qualification is:"+qualification4);
		writer.println("<p>SchoolName is:"+instituteName4);
		writer.println("<p>Percentage is:"+percentage4);
		writer.println("<p>Grade is:"+grade4); 
		writer.println("<br />");
		writer.println("<p>Check your uploaded image:"+pic);
		writer.println("<p>Check your uploaded Resume:"+resumeFileToUpload);
		writer.println("</div>");
		writer.println("</body>");
		writer.println("</head>");
		writer.println("</html>");
	}

}
