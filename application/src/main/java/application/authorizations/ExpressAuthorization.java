package application.authorizations;

import application.exceptions.NotAuthorizedException;
import domain.User;

public class ExpressAuthorization implements Authorization {
	private User user;
	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return this.user;
	}

	@Override
	public void isAuthorizrd() throws NotAuthorizedException {
		if(user == null)
			throw new NotAuthorizedException();
	}
}
