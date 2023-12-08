package memol.shop.app.services.site;

import memol.shop.app.entities.site.Blog;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.site.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repository;

    public List<Blog> search(String keyword){

        return repository.findAllByTitleContainsOrDescriptionContains(keyword);
    }
    public Blog getByID(long id){
       Optional<Blog> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
    public List<Blog> getAll(Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("publishDate"));
        Page<Blog> all=repository.findAll(page);
        return all.toList();
    }
    public long getAllCount(){
        return repository.count();
    }
    public Blog add(Blog data) throws Exception {
        if (data.getTitle()==null || data.getTitle().equals(""))
            throw new Exception("please fill title field");
        data.setVisitCount(0);
        return repository.save(data);
    }
    public Blog update(Blog data) throws DataNotFoundExeption {
        Blog oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setStatus(data.getStatus());
        return repository.save(oldData);
    }
    public Blog increaseVisitCount(long id) throws DataNotFoundExeption {
        Blog oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        oldData.setVisitCount(oldData.getVisitCount()+1);
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws DataNotFoundExeption {
        Blog oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }
}
