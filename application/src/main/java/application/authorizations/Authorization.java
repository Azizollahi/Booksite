package application.authorizations;

import application.exceptions.NotAuthorizedException;
import domain.User;

// todo: authorization should be moved into intercept
public interface Authorization {
	void setUser(User user);
	User getUser();
	void isAuthorizrd() throws NotAuthorizedException;
}
