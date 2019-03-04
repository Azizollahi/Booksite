package application.controllers;

import application.authorizations.Authorization;
import application.exceptions.NotAuthorizedException;
import application.factories.TopRecordSatisfactory;
import application.models.NewRecordModel;
import application.models.TopRecordsModel;
import domain.Book;
import domain.Record;
import domain_service_interfaces.top_records.RecordCalculator;
import infrastructure.repository.BookRepository;
import infrastructure.repository.RecordRepository;
import infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.LinkedList;

@Controller
@RequestMapping(path = "/profile")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ProfileController {
	private final RecordRepository recordRepository;
	private final BookRepository bookRepository;
	private final RecordCalculator recordCalculator;
	private final UserRepository userRepository;
	private final Authorization authorization;
	@Autowired
	public ProfileController(RecordRepository recordRepository, BookRepository bookRepository,
							 UserRepository userRepository, RecordCalculator recordCalculator,
							 Authorization authorization) {
		this.recordRepository = recordRepository;
		this.recordCalculator = recordCalculator;
		this.bookRepository = bookRepository;
		this.userRepository = userRepository;
		this.authorization = authorization;
	}

	@GetMapping(path = "/topRecords")
	public ModelAndView topRecords() {
		var records = recordRepository.findAll(Sort.by(Sort.Direction.DESC,"recordTime"));
		var model = new TopRecordsModel();
		model.setAverageReading(recordCalculator.averageTotalReadOnADay(records));
		model.setTotalReadingOfTheYear(recordCalculator.totalReadingOfTheYear(records));
		model.setTotalReading(recordCalculator.totalReading(records));
		model.setTotalReadingOfTheMonth(recordCalculator.totalReadingOfTheMonth(records));
		model.setTotalReadingOfTheDay(recordCalculator.totalReadingOfTheDay(records));
		model.setTotalReadingOfTheWeek(recordCalculator.totalReadingOfTheWeek(records));
		var listRecords = new LinkedList<Record>();
		for (var record : records
				) {
			if(listRecords.stream().noneMatch(x->x.getUser().getUserName().equals(record.getUser().getUserName()) && x.getBook().getName().equals(record.getBook().getName()))) {
				if(record.getRecordTime().compareTo(LocalDateTime.now().minusDays(1)) <= 0) {
					var days = Period.between(record.getRecordTime().toLocalDate(), LocalDateTime.now().toLocalDate()).getDays();
					if(days > 1)
						record.setImprovement(-days+(long)1);
					else
						record.setImprovement(0);
				}
				listRecords.add(record);
			}
		}
		model.setRecords(TopRecordSatisfactory.satisfyRecords(listRecords));
		var viewAndModel = new ModelAndView("top-records");
		viewAndModel.addObject("topRecord",model);
		return viewAndModel;
	}
	@PostMapping(path = "/newRecord")
	public ModelAndView newRecord(@Valid NewRecordModel newRecord, BindingResult result) throws NotAuthorizedException {
		authorization.isAuthorizrd();
		var viewAndModel = new ModelAndView();
		if(result.hasErrors()) {
			var model = new ModelAndView("redirect:/profile/newRecord");
			model.addObject("errorMessage", "Please properly fill the fields!");
			return model;
		}
		var records = recordRepository.findByBookNameAndUser(newRecord.getSelectedBook(), authorization.getUser().getUserName(), Sort.by(Sort.Direction.DESC,"recordTime"));
		var record = new Record();
		var recordTime = LocalDateTime.now();
		if(records == null || records.isEmpty() ){
			record.setLastRecordTime(recordTime);
			record.setImprovement(newRecord.getPageNumber());
		} else {
			var lastRecord = records.get(0);
			record.setLastRecordTime(lastRecord.getRecordTime());
			if(lastRecord.getPage() > newRecord.getPageNumber())
				record.setImprovement(0);
			else
				record.setImprovement(newRecord.getPageNumber() - lastRecord.getPage());
		}

		record.setRecordTime(recordTime);
		record.setPage(newRecord.getPageNumber());
		record.setBook(new Book(newRecord.getSelectedBook()));
		var user = userRepository.findByUserName(authorization.getUser().getUserName());
		record.setUser(user);
		recordRepository.save(record);
		viewAndModel.setViewName("redirect:/profile/topRecords");
		return viewAndModel;
	}
	@GetMapping(path = "/newRecord")
	public ModelAndView newRecord(String errorMessage) throws NotAuthorizedException {
		authorization.isAuthorizrd();
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
}
