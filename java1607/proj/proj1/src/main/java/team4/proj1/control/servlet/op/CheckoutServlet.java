package team4.proj1.control.servlet.op;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team4.proj1.control.servlet.CRUDServlet;
import team4.proj1.model.vo.check.Checkin;
import team4.proj1.model.vo.check.Checkout;
import team4.proj1.service.impl.admin.CusTypeServiceImpl;
import team4.proj1.service.impl.admin.RoomTypeServiceImpl;
import team4.proj1.service.impl.check.CheckinServiceImpl;
import team4.proj1.service.impl.check.CheckoutServiceImpl;

/**
 * 
 * @author 巫金桐
 * 
 */
public class CheckoutServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/op/checkout";
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
		CheckinServiceImpl cis = new CheckinServiceImpl();
		CheckoutServiceImpl cks = new CheckoutServiceImpl();
		
		// search by room
		RoomTypeServiceImpl rts = new RoomTypeServiceImpl();
		// serach by cus_info
		CusTypeServiceImpl cts = new CusTypeServiceImpl();

		List<Checkout> checkouts = null;
		List<Checkin> checkins = null;

		if (null != request.getParameter("byRoom")) {
			checkouts = cks.findByRoom(
					request.getParameter("start"),
					request.getParameter("end"),
					request.getParameter("chargeType"),
					request.getParameterValues("roomTypeNos"));
			
			request.setAttribute("totalAmount", computeTotalAmount(checkouts));
		} else if (null != request.getParameter("byCus")) {
			String status = request.getParameter("status");
			int cusCount = 0;
			
			if (status.equals("0")) {// find all
				checkins = cis.findUncheckByCus(
						request.getParameter("name"),
						request.getParameter("roomId"),
						request.getParameter("cusTypeNo"));
				checkouts = cks.findByCus(
						request.getParameter("name"),
						request.getParameter("roomId"),
						request.getParameter("cusTypeNo"));
			} else if (status.equals("1")) {// find unchecked
				checkins = cis.findUncheckByCus(
						request.getParameter("name"),
						request.getParameter("roomId"),
						request.getParameter("cusTypeNo"));
			} else if (status.equals("2")) {// find checked
				checkouts = cks.findByCus(
						request.getParameter("name"),
						request.getParameter("roomId"),
						request.getParameter("cusTypeNo"));
			}
		}

		String path = request.getContextPath();
		request.setAttribute("editUrl", path + SERVLET_URL
				+ "/edit?checkoutId=");
		request.setAttribute("deleteUrl", path + SERVLET_URL
				+ "?DELETE=&&checkoutId=");

		request.setAttribute("checkins", checkins);
		request.setAttribute("checkouts", checkouts);

		// search by room
		request.setAttribute("roomTypes", rts.findAll());
		// search by cus_info
		request.setAttribute("cusTypes", cts.findAll());

		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

	private float computeTotalAmount(List<Checkout> checkouts) {
		float total = 0.0f;
		for (Checkout checkout : checkouts) {
			total += checkout.getCheckoutAmount();
		}
		return total;
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CheckoutServiceImpl cos = new CheckoutServiceImpl();
		Checkout checkout = cos.checkout(request.getParameter("checkinId"),
				request.getParameter("amount"),
				request.getParameter("comment"));
		
		Float amount = Float.parseFloat(request.getParameter("amount"));
		request.setAttribute("checkout", checkout);
		request.setAttribute("change", checkout.getCheckin().getDeposit() + amount - checkout.getCheckoutAmount());
		request.getRequestDispatcher(TEMPLATE_URL + "/checkout_result.jsp").forward(request, response);
	}

	@Override
	public void getNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CheckoutServiceImpl cos = new CheckoutServiceImpl();
		Checkin checkin = null;
		
		String checkinId = request.getParameter("checkinId");
		String roomId = request.getParameter("roomId");
		
		if (checkinId != null) {
			checkin = cos.findByCheckinId(checkinId);
		} else if (roomId != null) {
			checkin = cos.findByRoomId(roomId);
		} else {
			request.setAttribute("checkins", cos.findAllUncheck());
		}
		
		request.setAttribute("checkin", checkin);
		request.setAttribute("newUrl", request.getContextPath() + SERVLET_URL + "/new?checkinId=");
		
		request.getRequestDispatcher(TEMPLATE_URL + "/new.jsp").forward(request, response);
		

	}
}
