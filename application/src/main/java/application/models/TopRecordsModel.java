package application.models;

import java.util.List;

public class TopRecordsModel {
	private List<RecordModel> record;

	private long averageReading;
	private long totalReadingOfTheDay;
	private long totalReadingOfTheWeek;
	private long totalReadingOfTheMonth;
	private long totalReadingOfTheYear;
	private long totalReading;

	public List<RecordModel> getRecord() {
		return record;
	}

	public void setRecords(List<RecordModel> record) {
		this.record = record;
	}

	public long getAverageReading() {
		return averageReading;
	}

	public void setAverageReading(long averageReading) {
		this.averageReading = averageReading;
	}

	public long getTotalReadingOfTheDay() {
		return totalReadingOfTheDay;
	}

	public void setTotalReadingOfTheDay(long totalReadingOfTheDay) {
		this.totalReadingOfTheDay = totalReadingOfTheDay;
	}

	public long getTotalReadingOfTheWeek() {
		return totalReadingOfTheWeek;
	}

	public void setTotalReadingOfTheWeek(long totalReadingOfTheWeek) {
		this.totalReadingOfTheWeek = totalReadingOfTheWeek;
	}

	public long getTotalReadingOfTheMonth() {
		return totalReadingOfTheMonth;
	}

	public void setTotalReadingOfTheMonth(long totalReadingOfTheMonth) {
		this.totalReadingOfTheMonth = totalReadingOfTheMonth;
	}

	public long getTotalReadingOfTheYear() {
		return totalReadingOfTheYear;
	}

	public void setTotalReadingOfTheYear(long totalReadingOfTheYear) {
		this.totalReadingOfTheYear = totalReadingOfTheYear;
	}

	public long getTotalReading() {
		return totalReading;
	}

	public void setTotalReading(long totalReading) {
		this.totalReading = totalReading;
	}
}
