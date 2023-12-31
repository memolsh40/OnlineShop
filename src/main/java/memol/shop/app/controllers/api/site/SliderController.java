package memol.shop.app.controllers.api.site;

import memol.shop.app.entities.site.Slider;
import memol.shop.app.helper.ui.ResponseStatus;
import memol.shop.app.helper.ui.ServiceResponse;
import memol.shop.app.services.site.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slider")
public class SliderController {

    @Autowired
    private SliderService service;

    @GetMapping("")
    public ServiceResponse<Slider> get (){
        try {
            List<Slider> result=service.findAllOrderByItemOrder();
            return new ServiceResponse<Slider>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Slider>(e);
        }

    }
    @GetMapping("/getAll")
    public ServiceResponse<Slider> getAll (@RequestParam Integer pageSize, @RequestParam Integer pageNumber){
        try {
            List<Slider> result=service.getAll(pageSize,pageNumber);
            long totalCount=service.getAllCount();
            return new ServiceResponse<Slider>(ResponseStatus.SUCCESS,result,totalCount);
        }catch (Exception e){
            return new ServiceResponse<Slider>(e);
        }

    }
    @GetMapping("/{id}")
    public ServiceResponse<Slider> search (@PathVariable long id ){
        try {
            Slider result=service.getByID(id);
            return new ServiceResponse<Slider>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Slider>(e);
        }

    }
    @PostMapping("/")
    public ServiceResponse<Slider> add (@RequestBody Slider data ){
        try {
            Slider result=service.add(data);
            return new ServiceResponse<Slider>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Slider>(e);
        }

    }

    @PostMapping("/changeOrder/{id}/{direction}")
    public ServiceResponse<Slider> changeOrder (@PathVariable long id, @PathVariable int direction){
        try {
            Slider result=service.changeOrder(id,direction);
            return new ServiceResponse<Slider>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Slider>(e);
        }

    }
    @PutMapping("/")
    public ServiceResponse<Slider> update (@RequestBody Slider data ){
        try {
            Slider result=service.update(data);
            return new ServiceResponse<Slider>(ResponseStatus.SUCCESS,result);
        }catch (Exception e){
            return new ServiceResponse<Slider>(e);
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





}
