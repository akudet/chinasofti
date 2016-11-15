package tp1.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp1.model.dao.impl.jdbc.RoomDAOImpl;
import tp1.model.dao.impl.jdbc.UserDAO;
import tp1.model.vo.admin.User;
import tp1.model.vo.room.Room;
import tp1.service.RoomService;
import tp1.service.UserService;
import tp1.servlet.CRUDServlet;

/**
 * 
 * @author 马厦伟
 * 
 */
public class UserServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/admin/user";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String userId = req.getParameter("userId");
		UserService mUserService = new UserService();
		int i = mUserService.deleteById(userId);
		doGet(req, resp);
		
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService us = new UserService();

		String userName = request.getParameter("userName");

		request.setAttribute("servletUrl", request.getContextPath() + SERVLET_URL);
		request.setAttribute("deleteUrl", request.getContextPath() + SERVLET_URL + "?DELETE=&userId=");
		
		if (userName != null) {
			UserDAO mUserDao = new UserDAO();
			User user = mUserDao.findByName(userName);
			
			List<User> users = new ArrayList<User>();
			users.add(user);
			if (user != null) {
			request.setAttribute("users", users);
			}
			request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp")
					.forward(request, response);
		} else {
			List<User> list = us.findAll();
			
			request.setAttribute("users", list);
			request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
					request, response);

		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("username");
		String userPass = request.getParameter("userpass");
		int privilege = Integer.parseInt(request.getParameter("privilege"));

		UserService us = new UserService();
		int flag = us.add(userName, userPass, privilege);
		if (flag > 0) {
			request.setAttribute("err_msg", "添加成功");
			this.doGet(request, response);
		} else {
			request.setAttribute("err_msg", "请添加数据");
			this.doGet(request, response);

		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		int privilege = Integer.parseInt(req.getParameter("privilege"));
		UserService us = new UserService();
		
		User user = us.findById((String) req.getSession().getAttribute("userId"));
		if (user.getPrivilege() == User.OP_PRIVILEGE) {
			if (user.getUserId().equals(userId)) {
				us.updateById(userId, userName, userPass, privilege);
			} else {
				req.setAttribute("err_msg", "只能修改自己的信息");
				req.getRequestDispatcher("/err.jsp").forward(req, resp);
				return;
			}
		}
		
		int flag = us.updateById(userId, userName, userPass, privilege);
		if (flag > 0) {
			req.setAttribute("err_msg", "修改成功");
			this.doGet(req, resp);
		} else {
			req.setAttribute("err_msg", "修改失败");
			this.doGet(req, resp);
		}
	}

	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String userId = req.getParameter("userId");
		UserDAO mUserDao = new UserDAO();
		User user = mUserDao.findById(userId);
		req.setAttribute("user", user);
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

	@Override
	public void getNew(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("12312");
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

}
