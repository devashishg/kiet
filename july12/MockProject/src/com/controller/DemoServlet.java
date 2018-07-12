package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bo.Employee;
import com.dao.EmployeeDAO;
import com.google.gson.Gson;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="oracledb")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		/*EmployeeDAO.dataSource = this.dataSource;
		List<Employee> list =  EmployeeDAO.getAllEmp();
		
		if(list.size()!=0) {
			System.out.println(list);
		}*/
		
		/*EmployeeDAO.dataSource = this.dataSource;
		
		Employee emp = new Employee(1, "dddd", "Modinagar", 7000.00);
		int i = EmployeeDAO.addEmployee(emp);
		if(i>0)
			System.out.println("added");*/
		
		
		/*EmployeeDAO.dataSource = this.dataSource;
		Employee emp = EmployeeDAO.getEmp(1);
		System.out.println(emp);*/
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		EmployeeDAO.dataSource = this.dataSource;
		
		InputStreamReader reader = new InputStreamReader(req.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		System.out.println(jsonString);
		
		Gson gson = new Gson();
		Employee emp =  gson.fromJson(jsonString, Employee.class);
		
		int i = EmployeeDAO.addEmployee(emp);
		if(i>0) {
			System.out.println("added");
			resp.getWriter().write(emp.getEmpid());
		}else {
			resp.getWriter().write("-1");
		}
	}

}
