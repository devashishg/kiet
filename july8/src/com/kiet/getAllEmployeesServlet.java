package com.kiet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class getAllEmployeesServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		List<Employee> employeeList = EmployeeDAO.getEmployees();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		
		String jsonString = gson.toJson(employeeList);
		response.getWriter().print(jsonString);
		
	}

}




