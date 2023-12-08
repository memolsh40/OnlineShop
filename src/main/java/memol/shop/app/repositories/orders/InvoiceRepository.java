package memol.shop.app.repositories.orders;

import memol.shop.app.entities.orders.Invoice;
import memol.shop.app.entities.people.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice,Long> {

    @Query("from Invoice where customer.id = :customerId")
List<Invoice> findAllByCustomer(long customerId);

}
