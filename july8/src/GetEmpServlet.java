

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.kiet.Employee;

/**
 * Servlet implementation class GetEmpServlet
 */
public class GetEmpServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		List<Employee> employeeList = new LinkedList<>();
		
		employeeList.add(new Employee(12, "Vishal", "Pune", 10000));
		employeeList.add(new Employee(13, "Vinod", "Mumbai", 12000));
		employeeList.add(new Employee(14, "Vilas", "Mumbai", 15000));
		
		PrintWriter writer = response.getWriter();
		writer.print("<html><head><title>all employees</title></head><body>");
		writer.print("<table border='1'>");
		writer.print("<tr>");
		writer.print("<td>EmpId</td>");
		writer.print("<td>Employee Name</td>");
		writer.print("<td>City</td>");
		writer.print("<td>Salary</td>");
		writer.print("</tr>");
		
		for(int i=0; i<employeeList.size(); i++) {
			Employee e = employeeList.get(i);
			writer.print("<tr>");
			writer.print("<td>"+e.getEmpid()+"</td>");
			writer.print("<td>"+e.getEname()+"</td>");
			writer.print("<td>"+e.getCity()+"</td>");
			writer.print("<td>"+e.getSalary()+"</td>");
			writer.print("</tr>");
		}
		writer.print("</table");
		writer.print("</body></html");

	}

}
