package com.cg.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.UserBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	public void init(){
		ServletContext servletContext=getServletContext();
		con=(Connection)servletContext.getAttribute("con");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		RequestDispatcher dispatcher;
		UserBean userBean=new UserBean(userName, password);
			PreparedStatement pstmt=con.prepareStatement("select password from userBean where username=?");
			pstmt.setString(1, userBean.getUserName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("password").equals(userBean.getPassword())){
					dispatcher=request.getRequestDispatcher("successPage.jsp");
					request.setAttribute("userBean", userBean);
					dispatcher.forward(request, response);
				}
				else{
					dispatcher=request.getRequestDispatcher("errorPage.jsp");
					request.setAttribute("errorMessage", "Password is incorrect");
					dispatcher.forward(request, response);
				}
			}
			else{
				dispatcher=request.getRequestDispatcher("errorPage.jsp");
				request.setAttribute("errorMessage", "Username or Password is incorrect");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
