package tp4.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.dao.ReservationDao;
import tp4.model.vo.Reservation;
import tp4.model.vo.RoomType;
import tp4.service.ReservationService;
import tp4.servlet.CRUDServlet;

/**
 * 
 * @author 马厦伟
 * 
 */
public class ReservationServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/op/reservation";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		super.doDelete(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReservationDao rd = new ReservationDao();
		ArrayList<Reservation> mReservation = rd.findAll();
		request.setAttribute("users", mReservation);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reservationId = request.getParameter("reservationId");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String roomTypeDesc = request.getParameter("roomTypeDesc");
		String arriveTime = request.getParameter("arriveTime");
		String reserveTime = request.getParameter("reserveTime");
		String reservationTime = request.getParameter("reservationTime");
		String comment = request.getParameter("comment");

		ReservationService rs = new ReservationService();

		int flag = rs.add(reservationId, name, phone, roomTypeDesc, arriveTime,
				reserveTime, reservationTime, comment);
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
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String arriveTime = req.getParameter("arriveTime");
		String reserveTime = req.getParameter("reserveTime");
		String reservationTime = req.getParameter("reservationTime");
		String comment = req.getParameter("comment");

		ReservationService rs = new ReservationService();

		int flag = rs.updateById(reservationId, name, phone, arriveTime,
				reserveTime, reservationTime, comment);
		if (flag > 0) {
			req.setAttribute("err_msg", "添加成功");
			this.doGet(req, resp);
		} else {
			req.setAttribute("err_msg", "添加失败");
			this.doGet(req, resp);
		}

		super.doPut(req, resp);
	}

	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
