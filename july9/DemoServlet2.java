package com.kiet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet2
 */
public class DemoServlet2 extends HttpServlet {
  
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig conf = getServletConfig();
		
		String dbdriver = conf.getInitParameter("dbdriver");
		String url = conf.getInitParameter("dburl");	
		String uname = conf.getInitParameter("uname");
		
	    ServletContext context = conf.getServletContext();
		String dname = context.getInitParameter("deptname");
		String cname = context.getInitParameter("collegename");
	    
		
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title> demo </title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h3>Driver : " + dbdriver + "</h1>");
		writer.print("<h3>Url : " + url + "</h1>");
		writer.print("<h3>Uname : " + uname + "</h1>");
		writer.print("<hr>");
		writer.print("<h3>College Name : " + cname + "</h1>");
		writer.print("<h3>Dept Name : " + dname + "</h1>");
		writer.print("</body>");
		writer.print("</html>");

		
	}

}
