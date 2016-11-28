package team4.proj2.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team4.proj2.model.dao.DAO;

public class BasicController<T> {

	/** basePath of views */
	private String mViewsPath = "";
	@Autowired
	private DAO<T> dao;

	@RequestMapping("/")
	public ModelAndView index() {
		return render("index");
	}

	private void log(HttpServletRequest req) {
		System.out.println(req.getMethod() + " : " + req.getRequestURI());
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") String id, HttpServletRequest req) {
		log(req);

		Map<String, T> map = new HashMap<String, T>();
		T model = dao.find(id);
		System.out.println(model + getModelName(model));
		if (null != model) {
			map.put(getModelName(model), model);
		}
		
		return render("show", map);
	}

	public String getModelName(T obj) {
		return obj.getClass().getSimpleName().toLowerCase();
	}

	// declare the controller as a submodule of its extends controller
	protected void submodule(String moduleName) {
		mViewsPath += moduleName + "/";
	}

	private String getViewName(String viewName) {
		return mViewsPath + viewName;
	}

	protected ModelAndView render(String viewName) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(getViewName(viewName));
		return mav;
	}

	protected ModelAndView render(String viewName, Map<String, ?> objs) {
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(objs);
		mav.setViewName(getViewName(viewName));
		return mav;
	}

}
