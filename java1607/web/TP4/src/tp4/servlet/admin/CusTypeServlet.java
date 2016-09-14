package tp4.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.vo.CusType;
import tp4.service.CusTypeService;
import tp4.service.UserService;
import tp4.servlet.util.CRUDServlet;

public class CusTypeServlet extends CRUDServlet {

	public static final String SERVLET_URL = "/admin/cus_type";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CusTypeService CTService= new CusTypeService();
		List<CusType> list=CTService.findAll();
		request.setAttribute("list",list );
		request.getRequestDispatcher(TEMPLATE_URL+"/index.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
		
		int cusTypeNo = Integer.parseInt(request.getParameter("cusTypeNo"));
		String cusTypeDesc = request.getParameter("cusTypeDesc");
		int discount =Integer.parseInt(request.getParameter("discount"));
		
		CusTypeService CTService = new CusTypeService();
		int flag = CTService.add(cusTypeNo, cusTypeDesc, discount);
		if (flag > 0) {
			request.getRequestDispatcher(TEMPLATE_URL+"/index.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("list", "请添加数据");
			request.getRequestDispatcher(TEMPLATE_URL+"/new.jsp").forward(request,
					response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp").forward(req, resp);
	}

	@Override
	public void getNew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(TEMPLATE_URL + req.getPathInfo() + ".jsp").forward(req, resp);
	}

}
