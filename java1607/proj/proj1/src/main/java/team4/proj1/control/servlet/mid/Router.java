package team4.proj1.control.servlet.mid;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 巫金桐
 * 
 * subclass should not overwrite service method
 *
 */
public abstract class Router extends HttpServlet {
	
	private Map<String, List<MiddleWare>> mDeleteRoutes = new HashMap<String, List<MiddleWare>>();
	private Map<String, List<MiddleWare>> mGetRoutes = new HashMap<String, List<MiddleWare>>();
	private Map<String, List<MiddleWare>> mPostRoutes = new HashMap<String, List<MiddleWare>>();
	private Map<String, List<MiddleWare>> mPutRoutes = new HashMap<String, List<MiddleWare>>();

	private void addRoute(Map<String, List<MiddleWare>> routes, String path,
			MiddleWare middleWare) {
		if (!routes.containsKey(path)) {
			routes.put(path, new ArrayList<MiddleWare>());
		}
		routes.get(path).add(middleWare);
	}
	
	final public void delete(String path, MiddleWare mw) {
		addRoute(mDeleteRoutes, path, mw);
	}

	final public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handle(mDeleteRoutes, request, response);
	}

	final public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handle(mGetRoutes, request, response);
	}

	final public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handle(mPostRoutes, request, response);
	}

	final public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handle(mPutRoutes, request, response);
	}
	
	final public void get(String path, MiddleWare middleWare) {
		addRoute(mGetRoutes, path, middleWare);
	}
	
	private void handle(Map<String, List<MiddleWare>> routes,
			HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String path = req.getPathInfo();
		if (null == path) {
			path = "/";
		}
		
		System.out.println(req.getMethod() + " : " + req.getRequestURI());
		System.out.println("PATH : " + path);

		
		for (Entry<String, List<MiddleWare>> entry : routes.entrySet()) {
			if (Pattern.matches(entry.getKey(), path)) {
				for (MiddleWare mw : entry.getValue()) {
					mw.service(req, resp);
				}
				return;
			}
		}
	}
	
	final public void post(String path, MiddleWare mw) {
		addRoute(mPostRoutes, path, mw);
	}

	final public void put(String path, MiddleWare mw) {
		addRoute(mPutRoutes, path, mw);
	}

	@Override
	final public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.service(req, resp);
	}

}
