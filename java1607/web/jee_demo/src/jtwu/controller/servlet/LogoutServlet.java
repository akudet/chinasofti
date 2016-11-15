package jtwu.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jtwu.controller.service.CookiesService;

public class LogoutServlet extends HttpServlet {

	public static final String SERVLET_URL = "/users/logout";
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		//I don't why redirect and dispatcher using a different url path
		response.sendRedirect(request.getContextPath() + LoginServlet.SERVLET_URL);
		//request.getRequestDispatcher(LoginServlet.SERVLET_URL).forward(request, response);
	}

}
