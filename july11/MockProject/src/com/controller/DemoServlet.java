package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bo.Employee;
import com.dao.EmployeeDAO;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="oracledb")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO.dataSource = this.dataSource;
		
		Employee emp = new Employee(18, "Mandeep", "Modinagar", 7000.00);
		int i = EmployeeDAO.addEmployee(emp);
		if(i>0)
			System.out.println("added");
	}

}
