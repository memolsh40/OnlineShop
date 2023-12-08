package memol.shop.app.repositories.site;

import memol.shop.app.entities.site.Nav;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavRepository extends PagingAndSortingRepository<Nav,Long> {
    List<Nav> findAllByEnableIsTrue(Sort sort);
    Nav findTopByOrderByItemOrderDesc();
    Nav findTopByItemOrder(int itemOrder);



}
