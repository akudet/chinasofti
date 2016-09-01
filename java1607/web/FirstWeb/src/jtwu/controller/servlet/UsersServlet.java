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
		
		String delete = request.getParameter("delete");
		if (null != delete) {
			doDelete(request, response);
			return;
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersService usersService = new UsersService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		int status = Integer.parseInt(request.getParameter("status"));
		
		User user = usersService.findUserById(id);

		user.setName(username);
		user.setPass(userpass);
		user.setStatus(status);
		usersService.updateUser(user);
		
		doGet(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersService usersService = new UsersService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = usersService.findUserById(id);

		usersService.deleteUser(user);
		doGet(request, response);
	}

}
