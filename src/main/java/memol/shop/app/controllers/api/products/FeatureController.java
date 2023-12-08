package memol.shop.app.controllers.api.products;

import memol.shop.app.entities.products.Feature;
import memol.shop.app.helper.ui.ResponseStatus;
import memol.shop.app.helper.ui.ServiceResponse;
import memol.shop.app.services.product.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {

    @Autowired
    private FeatureService service;


    @GetMapping("/{id}")
    public ServiceResponse<Feature> search (@PathVariable long id ){
        try {
            Feature result=service.getByID(id);
            return new ServiceResponse<Feature>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Feature>(e);
        }

    }
    @PostMapping("/")
    public ServiceResponse<Feature> add (@RequestBody Feature data ){
        try {
            Feature result=service.add(data);
            return new ServiceResponse<Feature>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Feature>(e);
        }

    }
    @PutMapping("/")
    public ServiceResponse<Feature> update (@RequestBody Feature data ){
        try {
            Feature result=service.update(data);
            return new ServiceResponse<Feature>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Feature>(e);
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





}
