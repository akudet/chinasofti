package jtwu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersServlet extends HttpServlet {
	Collection<User> users;

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

		request.setAttribute("users", users);
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		users = new ArrayList<User>();
		
		users.add(new User("jtwu", "jtwu"));
		users.add(new User("suzu", "jtwu"));
		users.add(new User("kyo", "jtwu"));
		users.add(new User("izumi", "jtwu"));
		users.add(new User("saya", "jtwu"));
	}

	

}
