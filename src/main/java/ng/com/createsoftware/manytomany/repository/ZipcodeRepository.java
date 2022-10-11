package ng.com.createsoftware.manytomany.repository;


import ng.com.createsoftware.manytomany.model.Zipcode;
import org.springframework.data.repository.CrudRepository;

public interface ZipcodeRepository extends CrudRepository<Zipcode, Long> {
}
