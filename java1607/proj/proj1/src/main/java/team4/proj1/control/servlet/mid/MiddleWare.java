package team4.proj1.control.servlet.mid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MiddleWare {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}
