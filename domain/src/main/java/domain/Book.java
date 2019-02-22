package domain;

import org.springframework.data.annotation.Id;

public class Book {
	public Book(){}
	public Book(String name){
		this.name = name;
	}
	@Id
	private String id;
	private String name;

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
}
