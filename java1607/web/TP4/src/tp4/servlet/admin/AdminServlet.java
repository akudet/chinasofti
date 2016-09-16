package tp4.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminServlet extends HttpServlet {

	public static final String SERVLET_URL = "/admin";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		
		request.setAttribute("cusTypeUrl", path + CusTypeServlet.SERVLET_URL);
		request.setAttribute("roomUrl", path + RoomServlet.SERVLET_URL);
		request.setAttribute("roomTypeUrl", path + RoomTypeServlet.SERVLET_URL);
		request.setAttribute("userUrl", path + UserServlet.SERVLET_URL);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(request, response);
	}

}
