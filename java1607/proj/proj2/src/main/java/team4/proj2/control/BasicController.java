package team4.proj2.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team4.proj2.model.dao.DAO;
import team4.proj2.model.vo.ValueObject;

public class BasicController<T extends ValueObject> {

	/** basePath of views */
	private String mViewsPath = "";
	@Autowired
	private DAO<T> dao;

	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public ModelAndView newPage(HttpServletRequest req) {
		return render("new");
	}

	@RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") String id,
			HttpServletRequest req) {
		return render("edit", dao.find(id));
	}

	@RequestMapping(path = { "/", "" })
	public ModelAndView index(HttpServletRequest req) {
		System.out.println(dao.findAll());
		return render("index", dao.findAll());
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") String id,
			HttpServletRequest req) {
		return render("show", dao.find(id));
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ModelAndView post(T model, HttpServletRequest req) {
		return render("show", dao.find(dao.insert(model)));
	}

	// simulated put and delete
	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable("id") String id, T model,
			HttpServletRequest req) {
		if (null != req.getParameter("PUT")) {
			return put(id, model, req);
		} else if (null != req.getParameter("DELETE")) {
			return delete(id, req);
		} else {
			return index(req);
		}

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ModelAndView put(@PathVariable("id") String id, T model,
			HttpServletRequest req) {
		model.setId(id);
		dao.update(model);
		return render("show", dao.find(id));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("id") String id,
			HttpServletRequest req) {
		dao.delete(dao.find(id));

		return index(req);
	}

	protected ModelAndView render(String viewName) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(getViewName(viewName));
		return mav;
	}

	protected ModelAndView render(String viewName, List<T> list) {
		ModelAndView mav = new ModelAndView();
		if (list.size() > 0) {
			mav.addObject(getSimpleName(list.get(0)) + "s", list);
		}
		System.out.println(mav.getModel());
		mav.setViewName(getViewName(viewName));
		return mav;
	}

	protected ModelAndView render(String viewName, Map<String, ?> objs) {
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(objs);
		mav.setViewName(getViewName(viewName));
		return mav;
	}

	protected ModelAndView render(String viewName, T object) {
		ModelAndView mav = new ModelAndView();
		if (null != object) {
			mav.addObject(getSimpleName(object), object);
		}
		mav.setViewName(getViewName(viewName));
		return mav;
	}

	// declare the controller as a submodule of its extends controller
	protected void submodule(String moduleName) {
		mViewsPath += moduleName + "/";
	}

	private String getSimpleName(Object obj) {
		return obj.getClass().getSimpleName().toLowerCase();
	}

	private String getViewName(String viewName) {
		return mViewsPath + viewName;
	}

}
