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
import tp4.model.vo.Room;
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
		CheckinService cis = new CheckinService();
		RoomService rs = new RoomService();
		VipService vs = new VipService();
		
		int checkinCount = cis.findAllUncheck().size();
		int checkoutCount = new CheckoutService().findAll().size();
		
		int t = cis.findAllChecked().size();
		if (t != checkoutCount) {
			System.out.println("REP INVAR CHECK FAILED");
		}
		
		int checkCount = checkinCount + checkoutCount;
		
		RoomDao rd = new RoomDao();
		
		int freeCount = rd.findByRoomStatus(Room.ROOM_STATUS_FREE).size();
		int inuseCount = rd.findByRoomStatus(Room.ROOM_STATUS_INUSE).size();
		int reservedCount = rd.findByRoomStatus(Room.ROOM_STATUS_RESERVED).size();
		int blockedCount = rd.findByRoomStatus(Room.ROOM_STATUS_BLOCKED).size();
		int totalCount = freeCount + inuseCount + reservedCount + blockedCount;
		
		request.setAttribute("freeCount", freeCount);
		request.setAttribute("inuseCount", inuseCount);
		request.setAttribute("reservedCount", reservedCount);
		request.setAttribute("blockedCount", blockedCount );
		request.setAttribute("totalCount", totalCount );
		
		request.setAttribute("labels", statService.getLabels());
		request.setAttribute("checkinStats", statService.getCheckinStatistics());
		request.setAttribute("checkoutStats", statService.getCheckoutStatistics());
		
		request.setAttribute("checkinCount", checkinCount);
		request.setAttribute("freeRoomCount", rs.findAllFreeRooms().size());
		request.setAttribute("vipCount", vs.findAll().size());
		request.setAttribute("checkCount", checkCount);
		
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(request, response);
	}

}
