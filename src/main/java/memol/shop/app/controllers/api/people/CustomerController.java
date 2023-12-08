package memol.shop.app.controllers.api.people;

import memol.shop.app.entities.people.Customer;
import memol.shop.app.helper.ui.ResponseStatus;
import memol.shop.app.helper.ui.ServiceResponse;
import memol.shop.app.services.people.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;



    @PostMapping("/")
    public ServiceResponse<Customer> add (@RequestBody Customer data ){
        try {
            Customer result=service.add(data);
            return new ServiceResponse<Customer>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Customer>(e);
        }

    }
    @GetMapping("/{id}")
    public ServiceResponse<Customer> search (@PathVariable long id ){
        try {
            Customer result=service.getByID(id);
            return new ServiceResponse<Customer>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Customer>(e);
        }

    }

    @DeleteMapping("/{id}")
    public ServiceResponse<Boolean> delete (@RequestBody long id ){
        try {
            Boolean result=service.deleteById(id);
            return new ServiceResponse<Boolean>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Boolean>(e);
        }

    }

    @PutMapping("/")
    public ServiceResponse<Customer> update (@PathVariable Customer data ){
        try {
            Customer result=service.update(data);
            return new ServiceResponse<Customer>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Customer>(e);
        }

    }





}
