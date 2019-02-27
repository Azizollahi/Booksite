package domain_service_interfaces.top_records;
import domain.Record;

import java.util.List;

public interface RecordCalculator {
	long averageTotalReadOnADay(List<Record> records);
	long totalReading(List<Record> records);
	long totalReadingOfTheDay(List<Record> records);
	long totalReadingOfTheWeek(List<Record> records);
	long totalReadingOfTheMonth(List<Record> records);
	long totalReadingOfTheYear(List<Record> records);
}
