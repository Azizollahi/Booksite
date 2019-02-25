package application.controllers;

import application.models.RecordModel;
import application.models.TopRecordsModel;
import infrastructure.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;

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
		var records = recordRepository.findAll(Sort.by(Sort.Direction.DESC,"recordTime"));
		var model = new TopRecordsModel();
		var recordModels = new LinkedList<RecordModel>();
		var recordModel = new RecordModel();
		recordModel.setBookName(records.get(0).getBook().getName());
		recordModel.setReaderName(records.get(0).getUser().getName());
		recordModel.setPageNumber(records.get(0).getPage());
		recordModel.setImprovement(records.get(0).getPage());
		recordModel.setUpdateTime(records.get(0).getRecordTime());
		recordModel.setLastUpdate(records.get(0).getRecordTime());
		recordModels.add(recordModel);
		model.setRecords(recordModels);
		model.setAverageReading(2);
		model.setTotalReading(200);
		model.setTotalReadingOfTheDay(3);
		model.setTotalReadingOfTheWeek(4);
		model.setTotalReadingOfTheMonth(5);
		model.setTotalReadingOfTheYear(6);
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
