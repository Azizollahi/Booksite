package infrastructure.repository;

import domain.Record;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends MongoRepository<Record,String> {

	@Query("{\"book\":{\"name\": ?0}},{\"user.userName\" : ?1}")
	List<Record> findByBookNameAndUser(String bookName, String userName, Sort sort);
}
