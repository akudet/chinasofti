package tp4.fliter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import tp4.servlet.admin.AdminServlet;
import tp4.servlet.admin.CusTypeServlet;
import tp4.servlet.admin.RoomServlet;
import tp4.servlet.admin.RoomTypeServlet;
import tp4.servlet.admin.UserServlet;
import tp4.servlet.op.CheckinServlet;
import tp4.servlet.op.CheckoutServlet;
import tp4.servlet.op.OpServlet;
import tp4.servlet.op.ReservationServlet;
import tp4.servlet.op.VipServlet;

/**
 * Servlet Filter implementation class PathFilter
 */
@WebFilter("/*")
public class PathFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PathFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getContextPath();
		
		request.setAttribute("adminUrl", path + AdminServlet.SERVLET_URL);
		request.setAttribute("opUrl", path + OpServlet.SERVLET_URL);
		
		request.setAttribute("cusTypeUrl", path + CusTypeServlet.SERVLET_URL);
		request.setAttribute("roomUrl", path + RoomServlet.SERVLET_URL);
		request.setAttribute("roomTypeUrl", path + RoomTypeServlet.SERVLET_URL);
		request.setAttribute("userUrl", path + UserServlet.SERVLET_URL);
		
		request.setAttribute("checkinUrl", path + CheckinServlet.SERVLET_URL);
		request.setAttribute("checkoutUrl", path + CheckoutServlet.SERVLET_URL);
		request.setAttribute("reservationUrl", path
				+ ReservationServlet.SERVLET_URL);
		request.setAttribute("vipUrl", path + VipServlet.SERVLET_URL);
		request.setAttribute("adminUrl", path + AdminServlet.SERVLET_URL);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
