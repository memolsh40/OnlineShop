package memol.shop.app.services.orders;

import memol.shop.app.entities.orders.Invoice;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.orders.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

public List<Invoice> findByCustomer(long customerId){
    return repository.findAllByCustomer(customerId);
}

    public Invoice getByID(long id){
       Optional<Invoice> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public Invoice add(Invoice data){
        return repository.save(data);
    }
    public Invoice update(Invoice data) throws DataNotFoundExeption {
        Invoice oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setPayDate(data.getPayDate());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundExeption {
        Invoice oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }

}
