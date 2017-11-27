package com.zhoudq.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhoudq.entity.User;

@Controller
public class UserController {
	@RequestMapping(value="/form")
	public ModelAndView userForm(){
		ModelAndView mav=new ModelAndView("userForm","user",new User());
		return mav;
	}
	
	@RequestMapping(value="/result")
	public ModelAndView processView(@Valid User user,BindingResult result) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("u",user);
		if(result.hasErrors())
			mav.setViewName("userForm");
		else
			mav.setViewName("userResult");
		
		return mav;
		
	}

}
