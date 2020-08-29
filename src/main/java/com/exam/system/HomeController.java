package com.exam.system;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.exam.system.models.Users;
import com.exam.system.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

	@RolesAllowed("USER")
	@RequestMapping("/*")
	public String studentHome(Model model) {
		
		return "student_index";
	}
	
	@RolesAllowed({"ADMIN","USER"})
	@RequestMapping("/admin")
	public String adminHome() {
		return "admin_index";
	}

	@RequestMapping("/quiz")
	public String exam() {
		return "quiz";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/saveRegister")
	public RedirectView addUser(Users user  ,RedirectAttributes redir) {
		userService.save(user);
RedirectView  redirectView= new RedirectView("/login",true);
		
	    redir.addFlashAttribute("message",	"You successfully registered! You can now login");
	        
	    return redirectView;
	}
	
}
