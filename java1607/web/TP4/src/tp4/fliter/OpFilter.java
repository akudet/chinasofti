package tp4.fliter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import tp4.service.AuthenticationService;

/**
 * Servlet Filter implementation class OpFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/op/*", "/main" })
public class OpFilter implements Filter {

    /**
     * Default constructor. 
     */
    public OpFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		String userId = (String) req.getSession().getAttribute("userId");
		
		if (null == userId) {
			req.setAttribute("err_msg",  "请先登录");
			req.getRequestDispatcher("/login").forward(request, response);
			return;
		}
		
		AuthenticationService as = new AuthenticationService();
		if (as.accept(userId, AuthenticationService.OP_ACESS)) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("err_msg",  "没有足够的权限访问该页面");
			req.getRequestDispatcher("/err.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
