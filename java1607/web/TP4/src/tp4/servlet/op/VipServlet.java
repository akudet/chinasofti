package tp4.servlet.op;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp4.model.dao.VipDao;
import tp4.model.vo.Vip;
import tp4.service.VipService;
import tp4.servlet.CRUDServlet;

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
		new VipDao().deleteById(Integer.parseInt(req.getParameter("vipNo")));
		resp.sendRedirect(req.getContextPath() + SERVLET_URL);
	}


	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String vipNumber = req.getParameter("vipNo");
		int vipNo = Integer.parseInt(vipNumber);
		String name = req.getParameter("name");
		
		VipService vs = new VipService();
		Vip vip1  = vs.findById(vipNumber);
		Vip vip2  = vs.findVipByName(name);
		
			if (vip1.getVipNo() == vipNo) {
				List<Vip> vips = new ArrayList<Vip>();
				vips.add(vip1);
				req.setAttribute("vips", vips);
			
		} else if (vip2.getCusInfo().getName().equals(name)) {
				List<Vip> vips = new ArrayList<Vip>();
				vips.add(vip2);
				req.setAttribute("vips", vips);
			
		}else{
			VipDao dao = new VipDao();
			req.setAttribute("vips", dao.findAll());
		}
		
		req.getRequestDispatcher(TEMPLATE_URL+"/index.jsp").forward(req, resp);

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
		VipDao dao = new VipDao();
		System.out.println(req.getParameter("vipNo"));
		req.setAttribute("vip", dao.findById(req.getParameter("vipNo")));
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
