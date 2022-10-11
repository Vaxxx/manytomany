package ng.com.createsoftware.manytomany.repository;

import ng.com.createsoftware.manytomany.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
