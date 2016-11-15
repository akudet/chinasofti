package team4.proj1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends Router {

	@Override
	public void init() throws ServletException {
		super.init();
		
		get("/.*", new StaticMiddleWare("/tmpl"));
	}

}
