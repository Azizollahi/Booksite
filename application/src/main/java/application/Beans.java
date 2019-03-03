package application;

import application.authorizations.Authorization;
import application.authorizations.ExpressAuthorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class Beans {
	@Bean
	@Scope("session")
	public Authorization getAuthorization(){
		return new ExpressAuthorization();
	}
}
