package application;

import application.authorizations.Authorization;
import application.authorizations.ExpressAuthorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
@Configuration
public class Beans {
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION)
	public Authorization getAuthorization(){
		return new ExpressAuthorization();
	}
}
