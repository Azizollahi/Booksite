package domain_service.top_records;

import domain.Record;
import domain_service_interfaces.top_records.RecordCalculator;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordCalculatorImpl implements RecordCalculator {
	public long averageTotalReadOnADay(List<Record> records){
		var currentRecords = records.stream()
				.filter(x->x.getRecordTime().compareTo(LocalDateTime.now().minusDays(14)) > 0).mapToLong(Record::getImprovement).sum();
		var pastRecords = records.stream().filter(x->x.getRecordTime().compareTo(LocalDateTime.now().minusDays(14)) <= 0).mapToLong(Record::getImprovement).sum();
		return (currentRecords-pastRecords)/records.stream().filter(x->x.getRecordTime().compareTo(LocalDateTime.now().minusDays(14)) > 0).count();
	}
	public long totalReading(List<Record> records){
		return records.stream().mapToLong(Record::getImprovement).sum();
	}
	public long totalReadingOfTheDay(List<Record> records){
		return records.stream()
				.filter(x->x.getRecordTime().compareTo(LocalDateTime.now().minusDays(1)) > 0)
				.mapToLong(Record::getImprovement).sum();
	}
	public long totalReadingOfTheWeek(List<Record> records){
		return records.stream()
				.filter(x->x.getRecordTime().compareTo(LocalDateTime.now().minusDays(7)) > 0)
				.mapToLong(Record::getImprovement).sum();
	}
	public long totalReadingOfTheMonth(List<Record> records){
		return records.stream()
				.filter(x->x.getRecordTime().compareTo(LocalDateTime.now().minusMonths(1)) > 0)
				.mapToLong(Record::getImprovement).sum();
	}
	public long totalReadingOfTheYear(List<Record> records){
		return records.stream()
				.filter(x->x.getRecordTime().compareTo(LocalDateTime.now().minusYears(1)) > 0)
				.mapToLong(Record::getImprovement).sum();
	}
}
