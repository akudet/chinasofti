package com.chinasofti.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;




import com.chinasofti.dao.UserDao;
import com.chinasofti.vo.User;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;

	@RequestMapping("/list/{id}")
	public ModelAndView selectById(@PathVariable("id") int id) {
		System.out.println(id);
		ModelAndView mav = new ModelAndView();
		User user = dao.selectById(1);
		System.out.println(user.getAddress()+"111111111111111111");
		mav.addObject("user",user);
		mav.setViewName("one");
		
		System.out.println(mav.getViewName());
		return mav;
	}
}
