package memol.shop.app.repositories.site;

import memol.shop.app.entities.site.Content;
import memol.shop.app.entities.site.Nav;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends PagingAndSortingRepository<Content,Long> {
    Content findFirstByKey(String key);
}
