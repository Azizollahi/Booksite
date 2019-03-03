package application.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginModel {
	@Email(message = "Email is not valid")
	@NotNull(message = "email is empty")
	@NotEmpty(message = "email is empty")
	private String email;
	@NotNull(message = "Password is empty")
	@NotEmpty(message = "Password is empty")
	private String password;
	private String errorMessage;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
