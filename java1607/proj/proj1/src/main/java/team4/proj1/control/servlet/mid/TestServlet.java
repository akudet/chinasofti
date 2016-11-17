package team4.proj1.control.servlet.mid;

import javax.servlet.ServletException;

public class TestServlet extends Router {

	@Override
	public void init() throws ServletException {
		super.init();
		
		get("/.*", new StaticMiddleWare("/tmpl"));
	}

}
