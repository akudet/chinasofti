package jtwu.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtwu.controller.service.UsersService;

public class ValidateServlet extends HttpServlet {

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

		UsersService us = new UsersService();
		Boolean exists = us.existsUser(request.getParameter("name"));
		
		response.setContentType("text/xml;");

		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' encoding='utf-8' ?>");
		out.println("<RESPONSE>");
		out.print("<EXISTS>" + exists);
		out.println("</EXISTS>");
		out.println("</RESPONSE>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsersService us = new UsersService();
		Boolean exists = us.existsUser(request.getParameter("name"));
		
		response.setContentType("text/xml;");

		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' encoding='utf-8' ?>");
		out.println("<RESPONSE>");
		out.print("<EXISTS>" + exists);
		out.println("</EXISTS>");
		out.println("</RESPONSE>");
		out.flush();
		out.close();
	}

}
