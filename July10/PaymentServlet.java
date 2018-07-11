package com.kiet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			double cread = Double.parseDouble(request.getParameter("cread"));
			double pread = Double.parseDouble(request.getParameter("pread"));
			
			double totalBill = (cread-pread)*5.00;
			response.getWriter().print("<h1> Total Bill = " + totalBill + "</h1>");
	}

}
