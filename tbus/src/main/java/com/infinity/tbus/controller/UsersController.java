package com.infinity.tbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.infinity.tbus.model.UserModel;
import com.infinity.tbus.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("registerRequest", new UserModel());
		return "register_page";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginRequest", new UserModel());
		return "login_page";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserModel userModel) {
		System.out.println("register request: " + userModel);
		UserModel registeredUser = usersService.registerUser(userModel.getLogin(),
				userModel.getPassword(), userModel.getEmail());
		return registeredUser == null ? "error_page" : "redirect:/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute UserModel userModel, Model model) {
		System.out.println("register request: " + userModel);
		UserModel authenticated = usersService.authenticate(userModel.getLogin(),
				userModel.getPassword());
		if(authenticated != null) {
			model.addAttribute("userLogin", authenticated.getLogin());
			return "personal_page";
		}else {
			return "error_page";
		}
	}
	
	
}
