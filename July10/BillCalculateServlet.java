package com.kiet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BillCalculateServlet
 */
public class BillCalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			PrintWriter writer = response.getWriter();
			
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<title> Calculate & Pay </title>");
			writer.print("</head>");
			
			writer.print("<body>");
			writer.print("<h1>Welcome to Bill Pay... </h1>");
			writer.print("<hr><br>");
			
			RequestDispatcher rd = request.getRequestDispatcher("pay");
			rd.include(request, response);
			
			writer.print("<br><br><h1>Thanks for the payment!...</h1>");
			writer.print("</body>");
			writer.print("</html>");
	}

}
