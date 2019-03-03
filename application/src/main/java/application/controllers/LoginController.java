package application.controllers;

import application.authorizations.Authorization;
import application.models.LoginModel;
import infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/auth")
public class LoginController {
	UserRepository userRepository;
	Authorization authorization;
	private static final String LOGIN_MODEL_NAME = "loginRequest";
	private static final String LOGIN_VIEW = "login";
	@Autowired
	public LoginController(UserRepository userRepository, Authorization authorization){
		this.userRepository = userRepository;
		this.authorization = authorization;
	}

	@GetMapping(path = "/login")
	public ModelAndView login(){
		var viewAndModel = new ModelAndView(LOGIN_VIEW);
		var model = new LoginModel();
		model.setEmail("haha");
		viewAndModel.addObject(LOGIN_MODEL_NAME, model);
		return viewAndModel;
	}

	@PostMapping(path = "/login")
	public ModelAndView login(@ModelAttribute("loginRequest") @Valid LoginModel model, BindingResult result){
		if(result.hasErrors()){
			var modelAndView = new ModelAndView(LOGIN_VIEW);
			modelAndView.addObject(LOGIN_MODEL_NAME,model);
			return modelAndView;
		}
		var user = userRepository.findByUserName(model.getEmail());
		if(user!= null && !user.getPassword().equals(model.getPassword())){
			var modelAndView = new ModelAndView(LOGIN_VIEW);
			model.setErrorMessage("Username/Password is not correct. please try again.");
			modelAndView.addObject(LOGIN_MODEL_NAME,model);
			return modelAndView;
		}
		authorization.setUser(user);
		return new ModelAndView("redirect:/profile/topRecords");
	}
}
