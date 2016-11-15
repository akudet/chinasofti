package tp1.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp1.model.dao.impl.jdbc.VipDAOImpl;
import tp1.model.vo.cus.Vip;
import tp1.service.VipService;
import tp1.servlet.CRUDServlet;

/**
 * 
 * @author 巫金桐
 * 
 */
public class VipServlet extends CRUDServlet {

	// 参考 2.7 会员管理

	public static final String SERVLET_URL = "/op/vip";
	public static final String TEMPLATE_URL = "/tmpl" + SERVLET_URL;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		new VipDAOImpl().deleteByVipNo(Integer.parseInt(req.getParameter("vipNo")));
		resp.sendRedirect(req.getContextPath() + SERVLET_URL);
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vipNumber = request.getParameter("vipNo");
		String name = request.getParameter("name");
		
		if (null != vipNumber) {
			VipService vs = new VipService();
			Vip vip  = vs.findById(vipNumber);
			if (vip != null) {
				List<Vip> vips = new ArrayList<Vip>();
				vips.add(vip);
				request.setAttribute("vips", vips);
			}
		} else if (null != name) {
			VipService vs = new VipService();
			Vip vip  = vs.findVipByName(name);
			if (vip != null) {
				List<Vip> vips = new ArrayList<Vip>();
				vips.add(vip);
				request.setAttribute("vips", vips);
			}
		}else{
			VipDAOImpl dao = new VipDAOImpl();
			request.setAttribute("vips", dao.findAll());
		}
		
		VipService vs = new VipService();
		if (request.getParameter("vip_no") != null) {
			Vip vip = vs.findById(request.getParameter("vip_no"));
			

			 response.setContentType("text/xml;charset=utf-8");
			 PrintWriter out = response.getWriter();  
			 response.setHeader("Cache-Control","no-cache");
			     out.println("<?xml version='1.0' encoding='"+"utf-8"+"' ?>");
					if (null != vip) {
						 out.println(vip.toXML());
					} else {
						out.println("<ERROR>not found</ERROR>");
					}
			    
			     out.close();
		} else {
			request.getRequestDispatcher(TEMPLATE_URL+"/index.jsp").forward(request, response);
		}

		

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		VipService service = new VipService();
		service.add(Integer.parseInt(req.getParameter("vipNo")),
				req.getParameter("name"), req.getParameter("sex"),
				req.getParameter("certNo"), req.getParameter("phone"),
				req.getParameter("address"), req.getParameter("comment"));
		resp.sendRedirect(req.getContextPath() + SERVLET_URL);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		VipService service = new VipService();
		req.setCharacterEncoding("utf-8");
		service.updateById(Integer.parseInt(req.getParameter("vipNo")),
				req.getParameter("name"), req.getParameter("sex"),
				req.getParameter("certNo"), req.getParameter("phone"),
				req.getParameter("address"), req.getParameter("comment"));
		resp.sendRedirect(req.getContextPath() + SERVLET_URL);
	}

	@Override
	public void getEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		VipDAOImpl dao = new VipDAOImpl();
		System.out.println(req.getParameter("vipNo"));
		req.setAttribute("vip", dao.findOneByVipNo(req.getParameter("vipNo")));
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
