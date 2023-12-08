package memol.shop.app.services.people;

import memol.shop.app.entities.people.Customer;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.people.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;



    public Customer getByID(long id){
       Optional<Customer> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public Customer add(Customer data){
        return repository.save(data);
    }
    public Customer update(Customer data) throws DataNotFoundExeption {
        Customer oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setAddress(data.getAddress());
        oldData.setEmail(data.getEmail());
        oldData.setFirstName(data.getFirstName());
        oldData.setLastName(data.getLastName());
        oldData.setMobile(data.getMobile());
        oldData.setPostalCode(data.getPostalCode());
        oldData.setTel(data.getTel());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundExeption {
        Customer oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }

}
