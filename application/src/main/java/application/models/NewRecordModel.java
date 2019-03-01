package application.models;

import java.util.List;

public class NewRecordModel {
	private String selectedBook;
	private long pageNumber;
	private List<String> books;

	public String getSelectedBook() {
		return selectedBook;
	}

	public void setSelectedBook(String selectedBook) {
		this.selectedBook = selectedBook;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
}
