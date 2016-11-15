package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.model.dao.UserDAO;
import demo.model.vo.User;

/**
 * 
 * @author Jintong Wu
 *
 * GET : /res -> index
 * GET : /res/new -> input
 * GET : /res/id/edit -> edit
 * 
 * GET : /res/id -> show
 * POST: /res -> post
 * PUT : /res/id -> update
 * DELETE: /res/id -> delete
 *
 * @param <T>
 */

public class AbstractController<T> {
	
	private UserDAO dao;

	@Autowired
	public AbstractController(UserDAO ud) {
		super();
		this.dao = ud;
	}

	@RequestMapping(value="/new")
	public String input() {
		return "new";
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.POST)
	public String post(User u) {
		System.out.println("post");
		dao.add(u);
		return "redirect:.";
	}
	
	@RequestMapping(value={"/put"})
	public String put(User u) {
		dao.update(u);
		return "redirect:.";
	}
	
	@RequestMapping(value={"/", "", "index"}, method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable(value="id") int id) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("edit");
		mav.addObject("user", dao.get(id));
		
		return mav;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView get(@PathVariable(value="id") int id) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("model");
		mav.addObject("model", dao.get(id));
		
		return mav;
	}
	
	
}
