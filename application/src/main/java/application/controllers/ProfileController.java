package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {
	@GetMapping(path = "/booksTable")
	public ModelAndView booksTable(){
		return new ModelAndView("groupBooksTable");
	}
	@GetMapping(path = "/newRecord")
	public ModelAndView newRecord(){
		return new ModelAndView("newRecord");
	}
	@GetMapping(path = "/newBook")
	public ModelAndView newBook(){
		return new ModelAndView("newBook");
	}
	@GetMapping(path = "/history")
	public ModelAndView history(){
		return new ModelAndView("history");
	}
}
