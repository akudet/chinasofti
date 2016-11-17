package team4.proj1.control.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team4.proj1.control.servlet.CRUDServlet;
import team4.proj1.model.vo.room.RoomType;
import team4.proj1.service.impl.admin.RoomTypeServiceImpl;

/**
 * 
 * @author 田霞光
 * 
 */
public class RoomTypeServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/admin/room_type";
	public static final String TEMPLATE_URL = "/tmpl/" + SERVLET_URL;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int roomtypeNo = Integer.parseInt(req.getParameter("roomTypeNo"));
		RoomTypeServiceImpl roomtype = new RoomTypeServiceImpl();
		int a = roomtype.deleteById(roomtypeNo);
		doGet(req, resp);

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RoomTypeServiceImpl us = new RoomTypeServiceImpl();
		List<RoomType> list = us.findAll();

		request.setAttribute("roomTypes", list);

		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomno = Integer.parseInt(request.getParameter("room_type_no"));
		String roomdesc = request.getParameter("room_type_desc");
		int beds = Integer.parseInt(request.getParameter("beds"));
		float price = Integer.parseInt(request.getParameter("price"));
		String isHourRoom = request.getParameter("isHourRoom");
		
		boolean hourRoom = isHourRoom.equals("true");
		
		float hourRoomPrice = Integer.parseInt(request
				.getParameter("hourRoomPrice"));
		String comment = request.getParameter("comment");
		RoomTypeServiceImpl roomtype = new RoomTypeServiceImpl();
		int a = roomtype.add(roomno, roomdesc, beds, price, hourRoom,
				hourRoomPrice, comment);
		if (a > 0) {
			doGet(request, response);
		} else {

			doGet(request, response);
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int roomno = Integer.parseInt(req.getParameter("room_type_no"));
		String roomdesc = req.getParameter("room_type_desc");
		int beds = Integer.parseInt(req.getParameter("beds"));
		float price = Float.parseFloat(req.getParameter("price"));
		String isHourRoom = req.getParameter("isHourRoom");
		boolean hourRoom = isHourRoom.equals("true");
		
		String comment = req.getParameter("comment");
		RoomTypeServiceImpl roomtype = new RoomTypeServiceImpl();
		int a = roomtype.updateById(
				roomno,
				roomdesc,
				beds,
				price,
				hourRoom,
				req.getParameter("hourRoomPrice"),
				comment);
		doGet(req, resp);

	}

	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int roomtypeNo = Integer.parseInt(req.getParameter("roomTypeNo"));
		RoomTypeServiceImpl roomtype = new RoomTypeServiceImpl();
		RoomType roomType = roomtype.findById(roomtypeNo);
		req.setAttribute("roomType", roomType);

		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

	@Override
	public void getNew(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

}
