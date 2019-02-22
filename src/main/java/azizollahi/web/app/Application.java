package azizollahi.web.app;

import domain.Book;
import infrastructure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"azizollahi.web.app.config",
		"application.controllers",
		"infrastructure.repository",
		"infrustracture.config",
		"domain"
})
public class Application implements ApplicationRunner {

	@Autowired
	public Application(BookRepository repository){
	}
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
	}
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
	}
}
