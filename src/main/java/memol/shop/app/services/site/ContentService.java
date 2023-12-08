package memol.shop.app.services.site;

import memol.shop.app.entities.site.Content;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.site.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    public Content findByKey(String key){

        return repository.findFirstByKey(key);
    }
    public Content getByID(long id){
       Optional<Content> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public List<Content> getAll(Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("id"));
        Page<Content> all=repository.findAll(page);
        return all.toList();
    }
    public long getAllCount(){
        return repository.count();
    }

    public Content add(Content data){
        return repository.save(data);
    }
    public Content update(Content data) throws DataNotFoundExeption {
        Content oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setValue(data.getValue());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws DataNotFoundExeption {
        Content oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }
}
