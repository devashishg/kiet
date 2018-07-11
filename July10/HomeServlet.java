package com.kiet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			String user = request.getParameter("uname");
			
			PrintWriter writer = response.getWriter();
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<title> welcome home </title>");
			writer.print("</head>");
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("fn")!=null) {
					String fname = (String) session.getAttribute("fn");
					
					writer.print("<body>");
					writer.print("<h1>Welcome to Home.. " + fname + "</h1>");
					writer.print("<a href='about.html'>About</a>");
					writer.print("<hr>");
			}else {
				writer.println("You are not allowed to view this page without login!...");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
			writer.print("</body>");
			writer.print("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
