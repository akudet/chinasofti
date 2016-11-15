package jtwu.filter;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtwu.controller.servlet.LoginServlet;
import jtwu.controller.servlet.UsersServlet;

public class TimeFilter implements Filter {
	int start, end;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		int hours = now.getHours();

		if (hours > start && hours < end) {
			request.setAttribute("err_msg", "You can't login at this time");
			//response.sendRedirect(request.getContextPath() + LoginServlet.SERVLET_URL);
			request.getRequestDispatcher(UsersServlet.TMPL_URL + "login.jsp").forward(request, response);
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		start = Integer.parseInt(arg0.getInitParameter("start"));
		end = Integer.parseInt(arg0.getInitParameter("end"));
	}

}
