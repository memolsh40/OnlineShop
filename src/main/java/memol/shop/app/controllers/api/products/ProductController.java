package memol.shop.app.controllers.api.products;

import memol.shop.app.entities.products.Product;
import memol.shop.app.helper.ui.ResponseStatus;
import memol.shop.app.helper.ui.ServiceResponse;
import memol.shop.app.helper.ui.uimodels.ProductVM;
import memol.shop.app.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;




    @GetMapping("/find")
    public ServiceResponse<Product> find (@RequestParam long cid ){
        try {
            List<Product> result=service.findAllOrderByCategory(cid);
            return new ServiceResponse<Product>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Product>(e);
        }

    }

    @GetMapping("/{id}")
    public ServiceResponse<Product> search (@PathVariable long id ){
        try {
            Product result=service.getByID(id);
            return new ServiceResponse<Product>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Product>(e);
        }

    }
    @PostMapping("/")
    public ServiceResponse<Product> add (@RequestBody ProductVM data ){
        try {
            Product result=service.add(data);
            return new ServiceResponse<Product>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Product>(e);
        }

    }
    @PutMapping("/")
    public ServiceResponse<Product> update (@RequestBody Product data ){
        try {
            Product result=service.update(data);
            return new ServiceResponse<Product>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Product>(e);
        }

    }
    @DeleteMapping("/{id}")
    public ServiceResponse<Boolean> delete (@PathVariable long id ){
        try {
            Boolean result=service.deleteById(id);
            return new ServiceResponse<Boolean>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Boolean>(e);
        }

    }
    @GetMapping("/getAll/{cid}")
    public ServiceResponse<Product> getAll (@RequestParam Integer pageSize, @RequestParam Integer pageNumber,@PathVariable long cid){
        try {
            List<Product> result=service.getAllByCategoryId(cid,pageSize,pageNumber);
            long totalCount=service.getAllCountByCategoryId(cid);
            return new ServiceResponse<Product>(ResponseStatus.SUCCESS,result,totalCount);
        }catch (Exception e){
            return new ServiceResponse<Product>(e);
        }

    }
    @GetMapping("/getAll")
    public ServiceResponse<Product> getAll (@RequestParam Integer pageSize, @RequestParam Integer pageNumber){
        try {
            List<Product> result=service.getAll(pageSize,pageNumber);
            long totalCount=service.getAllCount();
            return new ServiceResponse<Product>(ResponseStatus.SUCCESS,result,totalCount);
        }catch (Exception e){
            return new ServiceResponse<Product>(e);
        }

    }





}
