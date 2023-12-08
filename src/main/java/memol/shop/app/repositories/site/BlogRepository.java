package memol.shop.app.repositories.site;

import memol.shop.app.entities.site.Blog;
import memol.shop.app.entities.site.Nav;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {

    @Query("from Blog where title like concat('%',:search,'%') or description like  concat('%',:search,'%')")
    List<Blog> findAllByTitleContainsOrDescriptionContains(String search);
}
