package application.controllers;

import application.models.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/auth")
public class LoginController {

	@GetMapping(path = "/login")
	public ModelAndView login(){
		return new ModelAndView("login");
	}

	@PostMapping(path = "/login")
	public String login(LoginModel model){
		return "redirect:/profile/BooksTable";
	}
}
