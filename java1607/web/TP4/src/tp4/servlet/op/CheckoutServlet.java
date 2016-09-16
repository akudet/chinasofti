package tp4.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.dao.ChargeTypeDao;
import tp4.model.dao.CheckinDao;
import tp4.model.dao.RoomStatusDao;
import tp4.model.vo.Checkout;
import tp4.service.CheckoutService;
import tp4.service.CusTypeService;
import tp4.service.RoomTypeService;
import tp4.servlet.CRUDServlet;

/**
 * 
 * @author 巫金桐
 * 
 */
public class CheckoutServlet extends CRUDServlet {
	
	public static final String SERVLET_URL = "/op/checkout";
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
		CheckoutService cks = new CheckoutService();
		RoomTypeService rts = new RoomTypeService();
		CusTypeService cts = new CusTypeService();
		
		List<Checkout> checkouts;
		
		if (null != request.getParameter("byRoom")) {
			checkouts = cks.findByRoom(
					request.getParameter("start"),
					request.getParameter("end"),
					request.getParameter("chargeType"),
					request.getParameterValues("roomTypeNos"));
		} else if (null != request.getParameter("byCus")) {
			checkouts = cks.findAll();
		} else {
			checkouts = cks.findAll();
		}
		
		
		String path = request.getContextPath();
		request.setAttribute("editUrl", path + SERVLET_URL + "/edit?checkoutId=");
		request.setAttribute("deleteUrl", path + SERVLET_URL + "?DELETE=&&checkoutId=");
		
		request.setAttribute("checkouts", checkouts);
		request.setAttribute("roomTypes", rts.findAll());
		request.setAttribute("cusTypes", cts.findAll());
		request.setAttribute("chargeTypes", new ChargeTypeDao().findAll());
		request.setAttribute("roomStatuss", new RoomStatusDao().findAll());
		
		request.getRequestDispatcher(TEMPLATE_URL+"/index.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(request, response);
	}

	@Override
	public void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request, response);
	}

	@Override
	public void getNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("checkin", new CheckinDao().findAll().get(1));
		request.getRequestDispatcher(TEMPLATE_URL + request.getPathInfo() + ".jsp").forward(request, response);
	}
}
