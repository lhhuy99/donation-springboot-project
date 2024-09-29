package com.huylhfx13483.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminHomePage")
public class AdminHomeController {

	@GetMapping("/home")
	public String showHome() {
		return "admin/home";
	}
}
