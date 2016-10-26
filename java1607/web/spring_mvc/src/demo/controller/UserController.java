package demo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.model.dao.UserDAO;
import demo.model.vo.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private UserDAO ud;
	
	@Autowired
	public UserController(UserDAO ud) {
		super();
		this.ud = ud;
	}

	@RequestMapping(value="/new")
	public String input() {
		return "new";
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.POST)
	public String post(User u) {
		System.out.println("post");
		ud.add(u);
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
		mav.addObject("user", ud.get(id));
		
		return mav;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView get(@PathVariable(value="id") int id) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("model");
		mav.addObject("model", ud.get(id));
		
		return mav;
	}
	
}
