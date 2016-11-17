package team4.proj1.control.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team4.proj1.control.servlet.CRUDServlet;
import team4.proj1.model.dao.impl.jdbc.RoomDAOImpl;
import team4.proj1.model.dao.impl.jdbc.RoomTypeDAOImpl;
import team4.proj1.model.vo.room.Room;
import team4.proj1.model.vo.room.RoomType;
import team4.proj1.service.impl.admin.RoomServiceImpl;
import team4.proj1.service.impl.admin.RoomTypeServiceImpl;

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
		RoomServiceImpl roomService = new RoomServiceImpl();
		roomService.deleteById(roomId);
		doGet(request,response);
	
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoomServiceImpl rs = new RoomServiceImpl();
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
		
		List<RoomType> roomTypes = new RoomTypeServiceImpl().findAll();
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
		RoomServiceImpl rs = new RoomServiceImpl();
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
		RoomServiceImpl rs = new RoomServiceImpl();
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
		RoomDAOImpl rd = new RoomDAOImpl();
		Room room = rd.findOneByRoomId(roomID);
		request.setAttribute("room", room);
		request.setAttribute("roomTypes", new RoomTypeDAOImpl().findAll());
		request.getRequestDispatcher(
				TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request,
				response);
	}

	@Override
	public void getNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoomTypeServiceImpl rts = new RoomTypeServiceImpl();
		List<RoomType> roomTypes = rts.findAll();
		request.setAttribute("roomTypes", roomTypes);
		request.getRequestDispatcher(
				TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request,
				response);
	}

}
