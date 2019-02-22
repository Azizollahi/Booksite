package infrustracture.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"infrastructure.repository"})
@EntityScan(basePackages = {"domain"})
public class RepositoryBeans {
}
