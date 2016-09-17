package tp4.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.servlet.admin.AdminServlet;

/**
 * 
 * @author 巫金桐
 * 
 */
public class OpServlet extends HttpServlet {

	public static final String SERVLET_URL = "/op";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();

		request.setAttribute("checkinUrl", path + CheckinServlet.SERVLET_URL);
		request.setAttribute("checkoutUrl", path + CheckoutServlet.SERVLET_URL);
		request.setAttribute("reservationUrl", path
				+ ReservationServlet.SERVLET_URL);
		request.setAttribute("vipUrl", path + VipServlet.SERVLET_URL);
		request.setAttribute("adminUrl", path + AdminServlet.SERVLET_URL);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

}
