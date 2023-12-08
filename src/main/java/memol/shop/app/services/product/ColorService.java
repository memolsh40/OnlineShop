package memol.shop.app.services.product;

import memol.shop.app.entities.products.Color;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.product.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository repository;

    public Color getByID(long id){
       Optional<Color> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
    public List<Color> getAll(){

        return repository.findAll();
    }
    public List<Color> getAll(Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("id"));
        Page<Color> all=repository.findAll(page);
        return all.toList();
    }
    public long getAllCount(){
        return repository.count();
    }

    public Color add(Color data){
        return repository.save(data);
    }
    public Color update(Color data) throws DataNotFoundExeption {
        Color oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setName(data.getName());
        oldData.setValue(data.getValue());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundExeption {
        Color oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }
}
