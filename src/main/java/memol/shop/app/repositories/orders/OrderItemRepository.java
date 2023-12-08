package memol.shop.app.repositories.orders;

import memol.shop.app.entities.orders.OrderItem;
import memol.shop.app.entities.people.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem,Long> {


}
