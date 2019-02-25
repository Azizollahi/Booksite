package domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {
	@Id
	private String id;
	private String name;
	private String userName;
	private String password;
	private List<Book> bookHistory;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBookHistory() {
		return bookHistory;
	}

	public void setBookHistory(List<Book> bookHistory) {
		this.bookHistory = bookHistory;
	}
}
