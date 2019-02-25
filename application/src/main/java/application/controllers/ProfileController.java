package application.controllers;

import infrastructure.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {
	private final RecordRepository recordRepository;
	@Autowired
	public ProfileController(RecordRepository recordRepository){
		this.recordRepository = recordRepository;
	}

	@GetMapping(path = "/topRecords")
	public ModelAndView topRecords(){
		recordRepository.findAll(Sort.by(Sort.Direction.DESC,"recordTime"));
		return new ModelAndView("top-records");
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
