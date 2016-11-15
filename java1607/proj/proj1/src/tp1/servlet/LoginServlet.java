package tp1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp1.model.vo.admin.User;
import tp1.service.AuthenticationService;

public class LoginServlet extends HttpServlet {

	public static String SERVLET_URL = "/login";
	public static final String TEMPLATE_URL = "/tmpl";

	public static final String LOGIN_PAGE = TEMPLATE_URL + "/login.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("servletUrl", request.getContextPath()
				+ SERVLET_URL);
		request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");

		AuthenticationService ls = new AuthenticationService();
		User user = ls.login(username, userpass);

		if (user != null) {
			HttpSession session = request.getSession();
			String userId = user.getUserId();

			session.setMaxInactiveInterval(600);
			session.setAttribute("userId", userId);

			// request.setAttribute("msg", "登录成功");
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "登录失败");
			doGet(request, response);
		}
	}

}
