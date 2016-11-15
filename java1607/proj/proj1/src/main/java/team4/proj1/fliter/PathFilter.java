package team4.proj1.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import team4.proj1.servlet.LogoutServlet;
import team4.proj1.servlet.admin.AdminServlet;
import team4.proj1.servlet.admin.CusTypeServlet;
import team4.proj1.servlet.admin.RoomServlet;
import team4.proj1.servlet.admin.RoomTypeServlet;
import team4.proj1.servlet.admin.UserServlet;
import team4.proj1.servlet.op.CheckinServlet;
import team4.proj1.servlet.op.CheckoutServlet;
import team4.proj1.servlet.op.OpServlet;
import team4.proj1.servlet.op.ReservationServlet;
import team4.proj1.servlet.op.VipServlet;

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
		
		request.setAttribute("logoutUrl", path + LogoutServlet.SERVLET_URL);
		
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
