package tp4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.servlet.admin.AdminServlet;
import tp4.servlet.op.OpServlet;

public class MainServlet extends HttpServlet {

	public static final String SERVLET_URL = "/";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getContextPath();
		
		request.setAttribute("adminUrl", path + AdminServlet.SERVLET_URL);
		request.setAttribute("opUrl", path + OpServlet.SERVLET_URL);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(request, response);
	}

}
