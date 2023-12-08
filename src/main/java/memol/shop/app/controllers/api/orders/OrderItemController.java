package memol.shop.app.controllers.api.orders;

import memol.shop.app.entities.orders.OrderItem;
import memol.shop.app.helper.ui.ResponseStatus;
import memol.shop.app.helper.ui.ServiceResponse;
import memol.shop.app.services.orders.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService service;



    @PostMapping("/")
    public ServiceResponse<OrderItem> add (@RequestBody OrderItem data ){
        try {
            OrderItem result=service.add(data);
            return new ServiceResponse<OrderItem>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<OrderItem>(e);
        }

    }
    @GetMapping("/{id}")
    public ServiceResponse<OrderItem> search (@PathVariable long id ){
        try {
            OrderItem result=service.getByID(id);
            return new ServiceResponse<OrderItem>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<OrderItem>(e);
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
    public ServiceResponse<OrderItem> update (@RequestBody OrderItem data ){
        try {
            OrderItem result=service.update(data);
            return new ServiceResponse<OrderItem>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<OrderItem>(e);
        }

    }





}
