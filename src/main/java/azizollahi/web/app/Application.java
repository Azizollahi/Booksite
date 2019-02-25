package azizollahi.web.app;

import infrastructure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"azizollahi.web.app.config",
		"application.controllers",
		"infrastructure.repository",
		"infrustracture.config",
		"domain"
})
public class Application {

	@Autowired
	public Application(BookRepository repository){
	}
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
	}
}
