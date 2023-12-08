package memol.shop.app.repositories.product;

import memol.shop.app.entities.products.Feature;
import memol.shop.app.entities.products.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends PagingAndSortingRepository<Feature,Long> {


}
