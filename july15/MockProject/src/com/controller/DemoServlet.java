package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
import com.google.gson.GsonBuilder;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="oracledb")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO.dataSource = this.dataSource;
		List<Employee> list =  EmployeeDAO.getAllEmp();
		
		//System.out.println(list);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String jsonString = gson.toJson(list);
		response.getWriter().print(jsonString);
				
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

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			System.out.println("Put request received");
			
			InputStreamReader reader = new InputStreamReader(req.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			String jsonstr = br.readLine();
			
			Gson gson = new Gson();
			Employee emp = gson.fromJson(jsonstr, Employee.class);
			System.out.println(emp);
			
			EmployeeDAO.dataSource = this.dataSource;
			int res = EmployeeDAO.updateEmployee(emp);
			
			String jstr = "{updatesucess: 'ok', result: "+res+"}";
		
			resp.getWriter().print(gson.toJson(jstr));
			
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Delete request received");
		String jstr = "{deletesucess: 'ok'}";
		Gson gson = new Gson();
		resp.getWriter().print(gson.toJson(jstr));
	}
}


