package tp4.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.service.VipService;
import tp4.servlet.util.CRUDServlet;

public class VipServlet extends CRUDServlet {

	//参考 2.7 会员管理
	
	public static final String SERVLET_URL = "/op/vip";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;
	
	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

	@Override
	public void getNew(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("hello");
		req.getRequestDispatcher(TEMPLATE_URL + "/index.jsp")
		.forward(req, resp);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		VipService service = new VipService();
		service.add(
				Integer.parseInt(req.getParameter("vipNo")),
				req.getParameter("name"),
				req.getParameter("sex"),
				req.getParameter("certNo"),
				req.getParameter("phone"),
				req.getParameter("address"),
				req.getParameter("comment"));
		
	}

}
