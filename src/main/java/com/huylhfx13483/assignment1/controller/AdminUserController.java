package com.huylhfx13483.assignment1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huylhfx13483.assignment1.entity.User;
import com.huylhfx13483.assignment1.service.UserService;

@Controller
@RequestMapping("/adminUserPage")
public class AdminUserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String listAccount(Model theModel) {

		// get users
		List<User> theUsers = userService.getUsers();

		// add users, saveUser to model
		theModel.addAttribute("users", theUsers);

		theModel.addAttribute("saveUser", new User());
		return "admin/account";

	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("saveUser") User theUser) {

		// add user
		userService.saveUser(theUser);

		return "redirect:/adminUserPage/users";
	}

	// RequestParam attribute name="idUser"
	@PostMapping("/lock")
	public String lockUser(@RequestParam("idUser") int theId) {

		// get the user from the database
		User theUser = userService.getUserById(theId);

		if (theUser.getStatus() == 0) {
			theUser.setStatus(1);
		} else {
			theUser.setStatus(0);
		}

		// save user
		userService.saveUser(theUser);

		return "redirect:/adminUserPage/users";
	}

	@PostMapping("/send-mail")
	public String sendMail(@RequestParam("idUser") int theId, @RequestParam("note") String noteString) {

		// get the user from the database
		User theUser = userService.getUserById(theId);

		// set note
		theUser.setNote(noteString);

		// save user
		userService.saveUser(theUser);

		return "redirect:/adminUserPage/users";
	}

	@PostMapping("/delete")
	public String deleteUser(@RequestParam("idUser") int theId) {

		// delete the user
		userService.deleteUser(theId);

		return "redirect:/adminUserPage/users";
	}
}
