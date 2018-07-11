package com.kiet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class RegisterEmployeeServlet extends GenericServlet  {
	       
  	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
  		
  		PrintWriter writer = response.getWriter();
  		writer.print("<html><head><title>Adding employee</title></head>");
  		writer.print("<body>");
  		
  		writer.print("<h1>Adding Employee...</h1>");
  		
  		int eid = Integer.parseInt(request.getParameter("empid"));
  		String en = request.getParameter("ename");
  		String ct = request.getParameter("city");
  		double sal = Double.parseDouble(request.getParameter("sal"));

  		Employee emp = new Employee(eid, en, ct, sal);
  		int i = EmployeeDAO.addEmployee(emp);
  		
  		if(i>0) {
  			writer.print("<p>Employee Added Successfully");
  		}else {
  			writer.print("<p>Employee cannot be added");
  		}
  		
  		writer.print("</body>");
  		writer.print("</html>");
		
	}

}
