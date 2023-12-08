package memol.shop.app.repositories.people;

import memol.shop.app.entities.people.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
User findFirstByUsernameAndPassword(String userName,String password);
User findFirstByUsername(String userName);

}
