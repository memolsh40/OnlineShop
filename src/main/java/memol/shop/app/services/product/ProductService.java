package memol.shop.app.services.product;

import memol.shop.app.entities.products.Product;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.helper.ui.uimodels.ProductVM;
import memol.shop.app.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ProductCategoryService productCategoryService;

    public List<Product> findAllOrderByCategory(long categoryId){

        return repository.findAllByCategory(categoryId);
    }
    public List<Product> getAllByCategoryId(long categoryID,Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("id"));
        Page<Product> all=repository.findAllByCategory(categoryID,page);
        return all.toList();
    }
    public List<Product> getAll(Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("id"));
        Page<Product> all=repository.findAll(page);
        return all.toList();
    }
    public long getAllCount(){
        return repository.count();
    }
    public long getAllCountByCategoryId(long categoryId){
        return repository.countByCategoryId(categoryId);
    }
    public List<Product>search(String keyword){

        return repository.findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(keyword);
    }
    public Product getByID(long id){
       Optional<Product> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public Product add(ProductVM vm){
        Product data = vm.convert();
        if (vm.getFeatures()!=null)
        vm.getFeatures().forEach(x->data.addFeature(featureService.getByID(x)));

        if (vm.getColors()!=null)
        vm.getColors().forEach(x->data.addColor(colorService.getByID(x)));

        if (vm.getSizes()!=null)
        vm.getSizes().forEach(x->data.addSize(sizeService.getByID(x)));

        data.setCategory(productCategoryService.getByID(vm.getCategoryId()));
        data.setAddDate(new Date());
        return repository.save(data);
    }

    public Product update(Product data) throws DataNotFoundExeption {
        Product oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setEnable(data.isEnable());
        oldData.setExists(data.isExists());
        oldData.setPrice(data.getPrice());
        oldData.setFeatures(data.getFeatures());
        oldData.setSizes(data.getSizes());
        return repository.save(oldData);
    }
  
    public boolean deleteById(long id) throws DataNotFoundExeption {
        Product oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }
    public Product increaseVisitCount(long id) throws DataNotFoundExeption {
        Product oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        oldData.setVisitCount(oldData.getVisitCount()+1);
        return repository.save(oldData);
    }
}
