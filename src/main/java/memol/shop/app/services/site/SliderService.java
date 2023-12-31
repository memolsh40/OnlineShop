package memol.shop.app.services.site;

import memol.shop.app.entities.site.Slider;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.site.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SliderService {

    @Autowired
    private SliderRepository repository;

    public List<Slider> findAllOrderByItemOrder(){

        return repository.findAllByEnableIsTrue(Sort.by("itemOrder"));
    }
    public Slider getByID(long id){
       Optional<Slider> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public List<Slider> getAll(Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize,Sort.by("itemOrder"));
        Page<Slider> all=repository.findAll(page);
        return all.toList();
    }
    public long getAllCount(){
        return repository.count();
    }

    public Slider changeOrder(long id, int direction) throws Exception {
        Slider item = getByID(id);
        if (item==null) throw new Exception("item not found");
        switch (direction){
            case 1:
                //up
                if (item.getItemOrder()<=1)
                    return item;
                Slider siblingItem = repository.findTopByItemOrder(item.getItemOrder()-1);
                if (siblingItem == null)
                    item.setItemOrder(item.getItemOrder()-1);
                else {
                    item.setItemOrder(siblingItem.getItemOrder());
                    siblingItem.setItemOrder(item.getItemOrder()+1);
                    repository.save(siblingItem);
                }
                break;
            case 0:
                //down
                Slider siblingItem2 = repository.findTopByItemOrder(item.getItemOrder()+1);
                if (siblingItem2 == null) {
                    Slider lastOrderedItem = repository.findTopByOrderByItemOrderDesc();
                    if (item.getItemOrder() < lastOrderedItem.getItemOrder())
                        item.setItemOrder(item.getItemOrder()+1);
                }else {
                    item.setItemOrder(siblingItem2.getItemOrder());
                    siblingItem2.setItemOrder(item.getItemOrder()-1);
                    repository.save(siblingItem2);
                }
                break;
        }
        repository.save(item);
        return item;
    }

    public Slider add(Slider data){
        Slider lastItem=repository.findTopByOrderByItemOrderDesc();
        if (lastItem!=null && lastItem.getItemOrder()>0)
            data.setItemOrder(lastItem.getItemOrder()+1);
        else data.setItemOrder(1);
        return repository.save(data);
    }
    public Slider update(Slider data) throws DataNotFoundExeption {
        Slider oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setEnable(data.isEnable());
        oldData.setImage(data.getImage());
        oldData.setItemOrder(data.getItemOrder());
        oldData.setLink(data.getLink());
        return repository.save(oldData);
    }
    public boolean deleteById(long id) throws DataNotFoundExeption {
        Slider oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }
}
