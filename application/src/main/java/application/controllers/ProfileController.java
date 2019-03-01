package application.controllers;

import application.factories.TopRecordSatisfactory;
import application.models.NewRecordModel;
import application.models.TopRecordsModel;
import domain_service_interfaces.top_records.RecordCalculator;
import infrastructure.repository.BookRepository;
import infrastructure.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedList;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {
	private final RecordRepository recordRepository;
	private final BookRepository bookRepository;
	private final RecordCalculator recordCalculator;
	@Autowired
	public ProfileController(RecordRepository recordRepository, BookRepository bookRepository, RecordCalculator recordCalculator){
		this.recordRepository = recordRepository;
		this.recordCalculator = recordCalculator;
		this.bookRepository = bookRepository;
	}

	@GetMapping(path = "/topRecords")
	public ModelAndView topRecords(){
		var records = recordRepository.findAll(Sort.by(Sort.Direction.DESC,"recordTime"));
		var model = new TopRecordsModel();
		model.setAverageReading(recordCalculator.averageTotalReadOnADay(records));
		model.setTotalReadingOfTheYear(recordCalculator.totalReadingOfTheYear(records));
		model.setTotalReading(recordCalculator.totalReading(records));
		model.setTotalReadingOfTheMonth(recordCalculator.totalReadingOfTheMonth(records));
		model.setTotalReadingOfTheDay(recordCalculator.totalReadingOfTheDay(records));
		model.setRecords(TopRecordSatisfactory.satisfyRecords(records));
		var viewAndModel = new ModelAndView("top-records");
		viewAndModel.addObject("topRecord",model);
		return viewAndModel;
	}
	@PostMapping(path = "/newRecord")
	public ModelAndView newRecord(@Valid NewRecordModel newRecord, BindingResult result){
		var viewAndModel = new ModelAndView();
		if(result.hasErrors()) {
			var model = new ModelAndView("redirect:newRecord");
			model.addObject("errorMessage", "Please properly fill the fields!");
			return model;
		}
		viewAndModel.addObject("topRecord",newRecord);
		return viewAndModel;
	}
	@GetMapping(path = "/newRecord")
	public ModelAndView newRecord(String errorMessage){
		var books = bookRepository.findAll();
		var bookNames = new LinkedList<String>();
		for (var book: books)
			bookNames.add(book.getName());
		var model = new NewRecordModel();
		model.setErrorName(errorMessage);
		model.setBooks(bookNames);
		var viewAndModel = new ModelAndView("newRecord");
		viewAndModel.addObject("newRecord",model);
		return viewAndModel;
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
