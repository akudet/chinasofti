package tp4.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.dao.RoomDao;
import tp4.model.dao.VipDao;
import tp4.service.CheckStatisticService;
import tp4.service.CheckinService;
import tp4.service.CheckoutService;
import tp4.service.RoomService;
import tp4.service.VipService;
import tp4.servlet.admin.AdminServlet;
import tp4.servlet.op.OpServlet;

public class MainServlet extends HttpServlet {

	public static final String SERVLET_URL = "/";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CheckStatisticService statService = new CheckStatisticService();
		
		String path = request.getContextPath();
		
		int checkinCount = new CheckinService().findAll().size();
		int checkoutCount = new CheckoutService().findAll().size();
		int checkCount = checkinCount + checkoutCount;
		
		request.setAttribute("labels", statService.getLabels());
		request.setAttribute("checkinStats", statService.getCheckinStatistics());
		request.setAttribute("checkoutStats", statService.getCheckoutStatistics());
		
		request.setAttribute("checkinCount", checkinCount);
		request.setAttribute("freeRoomCount", new RoomDao().findAll().size());
		request.setAttribute("vipCount", new VipDao().findAll().size());
		request.setAttribute("checkCount", checkCount);
		
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(request, response);
	}

}
