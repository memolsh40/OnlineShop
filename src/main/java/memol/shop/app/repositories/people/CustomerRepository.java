package memol.shop.app.repositories.people;

import memol.shop.app.entities.people.Customer;
import memol.shop.app.entities.people.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {


}
