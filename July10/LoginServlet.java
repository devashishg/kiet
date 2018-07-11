package com.kiet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String fname = request.getParameter("fname");
		
		if(user.equals("abc") && pass.equals("xyz")) {
			//forward to HomeServlet
			
		  HttpSession session = request.getSession();
		  session.setAttribute("fn", fname);
		  //session.setMaxInactiveInterval(30*60);
		  
		  //response.sendRedirect("home");
		  
		  RequestDispatcher rd = request.getRequestDispatcher("home");
		  rd.forward(request, response);
			
		}else {
			//error message
			//PrintWriter writer = response.getWriter();
			//writer.print("Username and password is incorrect");
			//writer.print("<a href='login.html'>click here</a> to login again");
			response.sendRedirect("login.html");
		}
		
	}

}
