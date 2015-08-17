package com.spr.controller;

import com.spr.exception.UserNotFound;
import com.spr.model.User;
import com.spr.service.UserService;
import com.spr.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/user")
public class ActionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("user-new", "user", new User());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user,
			BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("user-new");
		
		ModelAndView mav = new ModelAndView();

		String message = "New user "+ user.getName()+" was successfully created.";

		userService.create(user);
		mav.setViewName("redirect:/index.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}

	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("user-edit");
		User user = userService.findById(id);
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user,
								 BindingResult result,
								 @PathVariable Integer id,
								 final RedirectAttributes redirectAttributes) throws UserNotFound {
		
		if (result.hasErrors())
			return new ModelAndView("user-edit");
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "User "+ user.getName()+" was successfully updated.";

		userService.update(user);
		 
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id,
								   final RedirectAttributes redirectAttributes) throws UserNotFound {
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");		
		
		User user = userService.delete(id);
		String message = "The user "+ user.getName()+" was successfully deleted.";
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}
