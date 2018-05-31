package com.cg.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.Communication;
import com.cg.bean.UserBean;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	public void init(){
		ServletContext servletContext=getServletContext();
		con=(Connection)servletContext.getAttribute("con");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		String gender=request.getParameter("gender");
		String [] communication=request.getParameterValues("communication");
		String graduation=request.getParameter("graduation");
		RequestDispatcher dispatcher;
		
		
	}

}
