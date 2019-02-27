package application.controllers;

import application.factories.TopRecordSatisfactory;
import application.models.TopRecordsModel;
import domain_service_interfaces.top_records.RecordCalculator;
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
	private final RecordCalculator recordCalculator;
	@Autowired
	public ProfileController(RecordRepository recordRepository, RecordCalculator recordCalculator){
		this.recordRepository = recordRepository;
		this.recordCalculator = recordCalculator;
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
