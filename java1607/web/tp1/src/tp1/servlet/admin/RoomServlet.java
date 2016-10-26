package tp1.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp1.model.dao.RoomDAO;
import tp1.model.dao.RoomTypeDAO;
import tp1.model.vo.Room;
import tp1.model.vo.RoomType;
import tp1.service.RoomService;
import tp1.service.RoomTypeService;
import tp1.servlet.CRUDServlet;

/**
 * 
 * @author 项双江
 * 
 */
public class RoomServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/admin/room";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;
	
	public static final String INDEX_PAGE = TEMPLATE_URL + "/index.jsp";

	@Override
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String roomId = request.getParameter("roomId");
		RoomService roomService = new RoomService();
		int i = roomService.deleteById(roomId);
		doGet(request,response);
	
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoomService rs = new RoomService();
		String roomTypeNo = request.getParameter("roomTypeNo");
		
		String pageNo = request.getParameter("pageNo");
		request.setAttribute("totalPage", rs.getTotalPages());
		
		if (pageNo != null) {
			request.setAttribute("rooms", rs.findPage(pageNo));
		} else if (roomTypeNo != null) {
			request.setAttribute("rooms", rs.findAllByTypeNo(roomTypeNo));
		} else {
			request.getRequestDispatcher(SERVLET_URL + "?pageNo=1").forward(request, response);
			return;
		}
		
		// find all roomTypes
		
		List<RoomType> roomTypes = new RoomTypeService().findAll();
		request.setAttribute("roomTypes", roomTypes);
		
		request.setAttribute("editUrl", request.getContextPath() + SERVLET_URL + "/edit?roomId=");
		request.setAttribute("deleteUrl", request.getContextPath() + SERVLET_URL + "?DELETE=&roomId=");

		request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
		int roomTypeNo = Integer.parseInt(request.getParameter("roomTypeNo"));
		String floor = request.getParameter("floor");
		String phone = request.getParameter("phone");
		int status = Integer.parseInt(request.getParameter("status"));
		String comment = request.getParameter("comment");
		RoomService rs = new RoomService();
		int flag = rs.add(roomID, roomTypeNo, floor, phone, status, comment);
		if (flag == 0) {
			request.setAttribute("msg", "添加房间成功");
			this.doGet(request, response);
		} else {
			request.setAttribute("msg", "添加房间失败");
			this.doGet(request, response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
		int roomTypeNo = Integer.parseInt(request.getParameter("roomTypeNo"));
		String floor = request.getParameter("floor");
		String phone = request.getParameter("phone");
		int status = Integer.parseInt(request.getParameter("status"));
		String comment = request.getParameter("comment");
		RoomService rs = new RoomService();
		int flag = rs.updateById(roomID, roomTypeNo, floor, phone, status,
				comment);
		if (flag == 0) {
			request.setAttribute("msg", "修改房间成功");
			this.doGet(request, response);
		} else {
			request.setAttribute("msg", "修改房间失败");
			this.doGet(request, response);
		}
	}

	@Override
	public void getEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
		RoomDAO rd = new RoomDAO();
		Room room = rd.findById(roomID);
		request.setAttribute("room", room);
		request.setAttribute("roomTypes", new RoomTypeDAO().findAll());
		request.getRequestDispatcher(
				TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request,
				response);
	}

	@Override
	public void getNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoomTypeService rts = new RoomTypeService();
		List<RoomType> roomTypes = rts.findAll();
		request.setAttribute("roomTypes", roomTypes);
		request.getRequestDispatcher(
				TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request,
				response);
	}

}
