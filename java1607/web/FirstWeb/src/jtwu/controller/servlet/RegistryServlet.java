package jtwu.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtwu.controller.service.RegistryService;

public class RegistryServlet extends HttpServlet {

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

		RegistryService regService = new RegistryService();
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		if (regService.registry(username, userpass) == RegistryService.REGISTRY_SUCC) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("err_msg", "注册失败");
			request.getRequestDispatcher("registry.jsp").forward(request, response);
		}
	}

}
