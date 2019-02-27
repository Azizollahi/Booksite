package domain;

import java.time.LocalDateTime;

public class Record {
	private User user;
	private Book book;
	private long page;
	private long improvement;
	private LocalDateTime lastRecordTime;
	private LocalDateTime recordTime;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public LocalDateTime getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(LocalDateTime recordTime) {
		this.recordTime = recordTime;
	}

	public long getImprovement() {
		return improvement;
	}

	public void setImprovement(long improvement) {
		this.improvement = improvement;
	}

	public LocalDateTime getLastRecordTime() {
		return lastRecordTime;
	}

	public void setLastRecordTime(LocalDateTime lastRecordTime) {
		this.lastRecordTime = lastRecordTime;
	}
}
