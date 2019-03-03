package domain;

import org.springframework.data.annotation.Id;

public class User {
	public User(){/* no arg constructor */}
	public User(User user){
		id = user.getId();
		name = user.getName();
		userName = user.getUserName();
		password = user.getPassword();
	}
	@Id
	private String id;
	private String name;
	private String userName;
	private String password;

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

}
