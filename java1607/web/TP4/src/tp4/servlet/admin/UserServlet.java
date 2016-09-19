package tp4.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.dao.RoomDao;
import tp4.model.dao.UserDao;
import tp4.model.vo.Room;
import tp4.model.vo.User;
import tp4.service.RoomService;
import tp4.service.UserService;
import tp4.servlet.CRUDServlet;

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
		List<User> list = us.findAll();
		
		request.setAttribute("deleteUrl", request.getContextPath() + SERVLET_URL + "?DELETE=&userId=");
		request.setAttribute("users", list);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);

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
		UserDao mUserDao = new UserDao();
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
