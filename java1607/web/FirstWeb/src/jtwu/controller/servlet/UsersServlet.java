package jtwu.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtwu.controller.service.RegistryService;
import jtwu.controller.service.UsersService;
import jtwu.model.User;
import jtwu.model.UserData;

public class UsersServlet extends HttpServlet {
	
	public static final String CONTENT_URL = "users/";

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsersService usersService = new UsersService();
		Collection<User> users = usersService.getUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher(CONTENT_URL + "index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String put = request.getParameter("put");
		if (null != put) {
			doPut(request, response);
			return;
		}
		
		RegistryService regService = new RegistryService();
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		if (regService.registry(username, userpass) == RegistryService.REGISTRY_SUCC) {
			doGet(request, response);
		} else {
			request.setAttribute("err_msg", "注册失败");
			request.getRequestDispatcher("registry.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersService userService = new UsersService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		int status = Integer.parseInt(request.getParameter("status"));
		
		User user = userService.findUserById(id);

		user.setName(username);
		user.setPass(userpass);
		user.setStatus(status);
		userService.updateUser(user);
		
		doGet(request, response);
	}

}
