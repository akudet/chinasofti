package tp4.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.dao.RoomDao;
import tp4.model.vo.Room;
import tp4.service.RoomService;
import tp4.servlet.CRUDServlet;

/**
 * 
 * @author 项双江
 * 
 */
public class RoomServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/admin/room";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomTypeNo = 0;
		RoomService rs = new RoomService();
		List<Room> rooms = rs.findByType(roomTypeNo);
		request.setAttribute("rooms", rooms);
		request.getRequestDispatcher(TEMPLATE_URL+"/index.jsp").forward(request, response);
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
		if (flag==0) {
			request.setAttribute("msg", "添加房间成功");
			this.doGet(request, response);
		} else {
			request.setAttribute("msg", "添加房间失败");
			this.doGet(request, response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
		int roomTypeNo = Integer.parseInt(request.getParameter("roomTypeNo"));
		String floor = request.getParameter("floor");
		String phone = request.getParameter("phone");
		int status = Integer.parseInt(request.getParameter("status"));
		String comment = request.getParameter("comment");
		RoomService rs = new RoomService();
		int flag = rs.updateById(roomID, roomTypeNo, floor, phone, status, comment);
		if (flag == 0) {
			request.setAttribute("msg", "修改房间成功");
			this.doGet(request, response);
		} else {
			request.setAttribute("msg", "修改房间失败");
			this.doGet(request, response);
		}
	}

	@Override
	public void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
		RoomDao rd = new RoomDao();
		Room room = rd.findById(roomID);
		request.setAttribute("room", room);
		request.getRequestDispatcher(TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request, response);
	}

	@Override
	public void getNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request, response);
	}

}
