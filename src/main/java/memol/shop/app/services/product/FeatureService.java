package memol.shop.app.services.product;

import memol.shop.app.entities.products.Feature;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.product.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository repository;

    public Feature getByID(long id){
       Optional<Feature> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public Feature add(Feature data){
        return repository.save(data);
    }
    public Feature update(Feature data) throws DataNotFoundExeption {
        Feature oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setValue(data.getValue());
        oldData.setKey(data.getKey());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundExeption {
        Feature oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }
}
