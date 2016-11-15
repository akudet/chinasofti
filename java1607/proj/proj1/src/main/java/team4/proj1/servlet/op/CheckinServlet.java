package team4.proj1.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team4.proj1.model.dao.impl.jdbc.CusTypeDAO;
import team4.proj1.model.dao.impl.jdbc.RoomDAOImpl;
import team4.proj1.model.dao.impl.jdbc.RoomTypeDAO;
import team4.proj1.model.vo.check.Checkin;
import team4.proj1.model.vo.cus.CusInfo;
import team4.proj1.model.vo.cus.CusType;
import team4.proj1.service.CheckinService;
import team4.proj1.servlet.CRUDServlet;

/**
 * 
 * @author 项双江
 * 
 */
public class CheckinServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/op/checkin";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		if (pathInfo != null && pathInfo.equals("/renew")) {
			handleRenew(request, response);
		} else {
			super.service(request, response);
		}
	}

	private void handleRenew(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CheckinService cis = new CheckinService();
		String checkinId = request.getParameter("checkinId");
		Checkin checkin = null;

		if (checkinId != null) {
			checkin = cis.findById(checkinId);
		} else {
			request.setAttribute("checkins", cis.findAllRenew());
		}

		request.setAttribute("checkin", checkin);
		request.setAttribute("renewUrl", request.getContextPath() + SERVLET_URL
				+ "/renew?checkinId=");

		request.getRequestDispatcher(TEMPLATE_URL + "/renew.jsp").forward(
				request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CheckinService cis = new CheckinService();

		List<Checkin> checkins = cis.findAll();
		String path = request.getContextPath();

		request.setAttribute("checkins", checkins);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CheckinService service = new CheckinService();

		CusType cusType = new CusTypeDAO().findById(Integer.parseInt(request
				.getParameter("cusTypeNo")));
		CusInfo cusInfo = new CusInfo();
		cusInfo.setName(request.getParameter("name"));
		cusInfo.setCusType(cusType);
		cusInfo.setSex(request.getParameter("sex"));
		cusInfo.setCertType(request.getParameter("certType"));
		cusInfo.setCertNumber(request.getParameter("certNumber"));
		cusInfo.setAddress(request.getParameter("address"));
		cusInfo.setComment(request.getParameter("comment"));
		Checkin checkin = service.checkin(
				request.getParameter("roomId"),
				cusInfo,
				request.getParameter("vipNo"),
				request.getParameter("checkinType"),
				request.getParameter("numOfDays"),
				request.getParameter("deposit"));
		request.setAttribute("checkin", checkin);
		doGet(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CheckinService cis = new CheckinService();
		
		if (request.getParameter("renew") != null) {
			String checkinId = request.getParameter("checkinId");
			cis.renew(checkinId, request.getParameter("reNumOfDays"),
					request.getParameter("reDeposit"));
		} else if (request.getParameter("edit") != null) {
			String checkinId = request.getParameter("checkinId");
			String certNumber = request.getParameter("certNumber");
			String address = request.getParameter("address");
			String comment = request.getParameter("comment");
			cis.updateCheckin(checkinId, certNumber, address, comment);
		}
		
		doGet(request, response);
	}

	@Override
	public void getEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CheckinService cis = new CheckinService();
		
		String checkinId = request.getParameter("checkinId");
		String path = request.getContextPath();
		request.setAttribute("editUrl", path + SERVLET_URL + "/edit?checkinId=");

		if (checkinId != null) {
			request.setAttribute("checkin", cis.findById(checkinId));
		} else {
			request.setAttribute("checkins", cis.findAll());
		}

		request.getRequestDispatcher(
				TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request,
				response);
	}

	@Override
	public void getNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CheckinService cis = new CheckinService();

		request.setAttribute("roomTypes", new RoomTypeDAO().findAll());
		
		request.setAttribute("room", new RoomDAOImpl().findOneByRoomId(request.getParameter("roomId")));
		request.setAttribute("cusTypes", new CusTypeDAO().findAll());

		String findRooms = request.getParameter("findRooms");
		if (findRooms != null) {
			request.setAttribute("rooms",
					cis.findFreeRooms(request.getParameter("roomTypeNo")));
		}

		request.getRequestDispatcher(TEMPLATE_URL + "/new.jsp").forward(
				request, response);
	}

}
