package team4.proj1.control.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team4.proj1.control.servlet.CRUDServlet;
import team4.proj1.model.dao.impl.jdbc.ReservationDAOImpl;
import team4.proj1.model.dao.impl.jdbc.RoomTypeDAOImpl;
import team4.proj1.model.vo.check.Reservation;
import team4.proj1.model.vo.room.RoomType;
import team4.proj1.service.impl.check.ReservationServiceImpl;

/**
 * 
 * @author 马厦伟
 * 
 */
public class ReservationServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/op/reservation";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	private String parseDateTime(String date, String time) {
		return date + " " + time;
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String reservationId = req.getParameter("reservationId");
		ReservationServiceImpl rs = new ReservationServiceImpl();
		int flag = rs.deleteById(reservationId);
		if(flag==0){
			req.setAttribute("msg", "删除成功");

			this.doGet(req, resp);
		}else{
			req.setAttribute("msg", "删除失败");
		
			this.doGet(req, resp);
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (null != request.getParameter("search")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String arriveTime = request.getParameter("arriveTime");
			ReservationServiceImpl rs = new ReservationServiceImpl();
			List<Reservation> reservations = rs.findAllReservation(name, phone, arriveTime);
			request.setAttribute("reservations", reservations);
		} else {
			ReservationServiceImpl rs = new ReservationServiceImpl();
			List<Reservation> reservations = rs.findAllReservation("", "", "");
			request.setAttribute("reservations", reservations);
		}
		String path = request.getContextPath();
		request.setAttribute("editUrl", path + SERVLET_URL + "/edit?reservationId=");
		request.setAttribute("newUrl", path + SERVLET_URL + "/new");
		request.setAttribute("deleteUrl", path + SERVLET_URL + "?DELETE=&reservationId=");
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomTypeNo = request.getParameter("roomTypeNo");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String arriveTime = parseDateTime(request.getParameter("arriveDate"), request.getParameter("arriveTime"));
		String reserveTime = parseDateTime(request.getParameter("reserveDate"), request.getParameter("reserveTime"));
		String comment = request.getParameter("comment");

		ReservationServiceImpl rs = new ReservationServiceImpl();
	
		int flag = 0;
		rs.reserve(roomTypeNo, name, phone, arriveTime, reserveTime, comment);
		if (flag > 0) {
			request.setAttribute("err_msg", "添加成功");
			this.doGet(request, response);
		} else {
			request.setAttribute("err_msg", "添加失败");
			this.doGet(request, response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String reservationId = req.getParameter("reservationId");
		String roomTypeNo = req.getParameter("roomTypeNo");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String arriveTime = req.getParameter("arriveTime");
		String reserveTime = req.getParameter("reserveTime");
		String reservationTime = req.getParameter("reservationTime");
		String comment = req.getParameter("comment");

		ReservationServiceImpl rs = new ReservationServiceImpl();

		int flag = rs.updateById(reservationId, roomTypeNo, name, phone, arriveTime, reserveTime, reservationTime, comment);
		if (flag > 0) {
			req.setAttribute("err_msg", "修改成功");
			this.doGet(req, resp);
		} else {
			req.setAttribute("err_msg", "修改失败");
			this.doGet(req, resp);
		}

	}

	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String reservationId = req.getParameter("reservationId");
		ReservationDAOImpl reservationDao = new ReservationDAOImpl();
		Reservation reservation = reservationDao.findById(reservationId);
		
		System.out.println(reservation);
		
		req.setAttribute("roomTypes", new RoomTypeDAOImpl().findAll());
		req.setAttribute("reservation", reservation);
		
		req.getRequestDispatcher(TEMPLATE_URL + "/edit.jsp")
				.forward(req, resp);
	}

	@Override
	public void getNew(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("roomTypes", new RoomTypeDAOImpl().findAll());
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

}
