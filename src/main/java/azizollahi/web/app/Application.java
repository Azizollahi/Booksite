package azizollahi.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"application",
		"azizollahi.web.app.config",
		"application.controllers",
		"infrastructure.repository",
		"infrastructure.config",
		"domain",
		"domain_service.top_records",
		"domain_service_interfaces.top_records",
		"infrastructure.config"
})
public class Application {

	public Application(){ /* no arh constructor */ }
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
	}
}
