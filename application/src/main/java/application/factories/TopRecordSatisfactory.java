package application.factories;

import application.models.RecordModel;
import domain.Record;
import java.util.LinkedList;
import java.util.List;

public class TopRecordSatisfactory {
	private TopRecordSatisfactory(){}
	public static List<RecordModel> satisfyRecords(List<Record> records){
		var recordModels =  new LinkedList<RecordModel>();
		for(var record : records){
			var recordModel = new RecordModel();
			recordModel.setBookName(record.getBook().getName());
			recordModel.setLastUpdate(record.getLastRecordTime());
			recordModel.setUpdateTime(record.getRecordTime());
			recordModel.setImprovement(record.getImprovement());
			recordModel.setPageNumber(record.getPage());
			recordModel.setReaderName(record.getUser().getName());
			recordModels.add(recordModel);
		}
		return recordModels;
	}
}
