package ng.com.createsoftware.manytomany.repository;

import ng.com.createsoftware.manytomany.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
