package ng.com.createsoftware.manytomany.repository;

import ng.com.createsoftware.manytomany.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
