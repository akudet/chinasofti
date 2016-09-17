package tp4.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.dao.CheckinDao;
import tp4.model.dao.CusInfoDao;
import tp4.model.dao.CusTypeDao;
import tp4.model.dao.RoomDao;
import tp4.model.dao.VipDao;
import tp4.model.vo.Checkin;
import tp4.model.vo.CusInfo;
import tp4.model.vo.CusType;
import tp4.model.vo.Room;
import tp4.service.CheckinService;
import tp4.servlet.CRUDServlet;

/**
 * 
 * @author 项双江
 * 
 */
public class CheckinServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/op/checkin";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

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
		request.setAttribute("editUrl", path + SERVLET_URL + "/edit?checkinId=");
		request.setAttribute("checkoutUrl", path + CheckoutServlet.SERVLET_URL + "/new?checkinId=");
		request.setAttribute("checkins", checkins);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CheckinService service = new CheckinService();

		CusInfo cusInfo = new CusInfoDao().findAll().get(1);

		int i = service.checkin(request.getParameter("roomId") ,cusInfo,
				request.getParameter("checkinType"),
				request.getParameter("num_of_days"),
				request.getParameter("deposit"));
		if (i == 0) {
			request.setAttribute("msg", "订房成功！");
			this.doGet(request, response);
		} else {
			request.setAttribute("msg", "订房失败！");
			this.doGet(request, response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(request, response);
	}

	@Override
	public void getEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CheckinService cis = new CheckinService();
		Checkin checkin = cis.findById(request.getParameter("checkinId"));
		request.setAttribute("checkin", checkin);
		request.getRequestDispatcher(
				TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request,
				response);
	}

	@Override
	public void getNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(
				TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request,
				response);
	}

}
