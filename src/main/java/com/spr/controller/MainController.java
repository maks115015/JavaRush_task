package com.spr.controller;

import com.spr.exception.UserNotFound;
import com.spr.model.User;
import com.spr.repository.UserRepository;
import com.spr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	private UserRepository repository;
	@Autowired
	private UserService userService;

@RequestMapping(value={"/","/index"}, method= RequestMethod.GET)
public ModelAndView userListPage(WebRequest webRequest) {
	int a=1;
	if((webRequest.getParameter("page")!=null))
		a=Integer.parseInt(webRequest.getParameter("page"));

	ModelAndView mav = new ModelAndView("index");

	Page<User> page = repository.findAll(new PageRequest(a - 1, 10));
	List<User>users=page.getContent();
	List<Integer>list=new ArrayList<>();
	for(int i=1;i<page.getTotalPages()+1;i++){
		list.add(i);
	}
	mav.addObject("users", users);
	mav.addObject("page",page);
	mav.addObject("list",list);
	return mav;
}


	@RequestMapping(value={"/","/index"}, method= RequestMethod.POST)
	public ModelAndView findByName(@RequestParam String searchName, final RedirectAttributes redirectAttributes) throws UserNotFound
	{
		List<User> user = userService.getByName(searchName);
		if (user.isEmpty()){
			String message="Wrong name";
			redirectAttributes.addFlashAttribute("message", message);
			ModelAndView mav = new ModelAndView("redirect:/index.html");
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("user");
			mav.addObject("users", user);
		return mav;
		}
	}


	
}
