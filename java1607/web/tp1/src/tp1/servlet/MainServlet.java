package tp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp1.model.dao.impl.jdbc.RoomDAOImpl;
import tp1.model.dao.impl.jdbc.VipDAOImpl;
import tp1.model.vo.room.Room;
import tp1.service.CheckStatisticService;
import tp1.service.CheckinService;
import tp1.service.CheckoutService;
import tp1.service.RoomService;
import tp1.service.VipService;
import tp1.servlet.admin.AdminServlet;
import tp1.servlet.op.OpServlet;

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
		
		RoomDAOImpl rd = new RoomDAOImpl();
		
		int freeCount = rd.findAllByRoomStatus(Room.ROOM_STATUS_FREE).size();
		int inuseCount = rd.findAllByRoomStatus(Room.ROOM_STATUS_INUSE).size();
		int reservedCount = rd.findAllByRoomStatus(Room.ROOM_STATUS_RESERVED).size();
		int blockedCount = rd.findAllByRoomStatus(Room.ROOM_STATUS_BLOCKED).size();
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
