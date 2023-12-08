package memol.shop.app.services.orders;

import memol.shop.app.entities.orders.OrderItem;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.orders.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;



    public OrderItem getByID(long id){
       Optional<OrderItem> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public OrderItem add(OrderItem data){
        return repository.save(data);
    }
    public OrderItem update(OrderItem data) throws DataNotFoundExeption {
        OrderItem oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setCount(data.getCount());
        oldData.setPrice(data.getPrice());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundExeption {
        OrderItem oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }

}
