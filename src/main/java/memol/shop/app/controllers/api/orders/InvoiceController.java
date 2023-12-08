package memol.shop.app.controllers.api.orders;

import memol.shop.app.entities.orders.Invoice;
import memol.shop.app.helper.ui.ResponseStatus;
import memol.shop.app.helper.ui.ServiceResponse;
import memol.shop.app.services.orders.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;



    @PostMapping("/")
    public ServiceResponse<Invoice> add (@RequestBody Invoice data ){
        try {
            Invoice result=service.add(data);
            return new ServiceResponse<Invoice>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Invoice>(e);
        }

    }
    @GetMapping("/{id}")
    public ServiceResponse<Invoice> search (@PathVariable long id ){
        try {
            Invoice result=service.getByID(id);
            return new ServiceResponse<Invoice>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Invoice>(e);
        }

    }
    @GetMapping("/find")
    public ServiceResponse<Invoice> find (@RequestParam long cid ){
        try {
            List<Invoice> result=service.findByCustomer(cid);
            return new ServiceResponse<Invoice>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Invoice>(e);
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
    public ServiceResponse<Invoice> update (@RequestBody Invoice data ){
        try {
            Invoice result=service.update(data);
            return new ServiceResponse<Invoice>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Invoice>(e);
        }

    }





}
