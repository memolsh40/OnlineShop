package memol.shop.app.repositories.product;

import memol.shop.app.entities.products.Size;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends PagingAndSortingRepository<Size,Long> {

    @Override
    List<Size> findAll();

}
