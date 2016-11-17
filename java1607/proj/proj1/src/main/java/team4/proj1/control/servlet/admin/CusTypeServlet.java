package team4.proj1.control.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team4.proj1.control.servlet.CRUDServlet;
import team4.proj1.model.vo.cus.CusType;
import team4.proj1.service.impl.admin.CusTypeServiceImpl;

/**
 * 
 * @author 范中兴
 * 
 */
public class CusTypeServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/admin/cus_type";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int cusTypeNo = Integer.parseInt(req.getParameter("cusTypeNo"));
		CusTypeServiceImpl cusTypeServiceImpl = new CusTypeServiceImpl();
		cusTypeServiceImpl.deleteById(cusTypeNo);
		doGet(req,resp);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CusTypeServiceImpl CTService = new CusTypeServiceImpl();
		List<CusType> list = CTService.findAll();
		request.setAttribute("cusTypes", list);
		request.getRequestDispatcher(TEMPLATE_URL + "/index.jsp").forward(
				request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int cusTypeNo = Integer.parseInt(request.getParameter("cusTypeNo"));
		String cusTypeDesc = request.getParameter("cusTypeDesc");
		int discount = Integer.parseInt(request.getParameter("discount"));

		CusTypeServiceImpl CTService = new CusTypeServiceImpl();
		CTService.add(cusTypeNo, cusTypeDesc, discount);
		doGet(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int cusTypeNo = Integer.parseInt(req.getParameter("cusTypeNo"));
		String cusTypeDesc = req.getParameter("cusTypeDesc");
		int discount = Integer.parseInt(req.getParameter("discount"));

		CusTypeServiceImpl CTService = new CusTypeServiceImpl();
		int flag = CTService.updateById(cusTypeNo, cusTypeDesc, discount);
		if (flag > 0) {
			req.setAttribute("err_msg", "修改完成");
			this.doGet(req, resp);
		} else {
			req.setAttribute("err_msg", "修改出错，请重新修改");
			this.doGet(req, resp);

		}
		
	}

	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("cusType", new CusTypeServiceImpl().findById(Integer.parseInt(req.getParameter("cusTypeNo"))));
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

	@Override
	public void getNew(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp")
				.forward(req, resp);
	}

}
