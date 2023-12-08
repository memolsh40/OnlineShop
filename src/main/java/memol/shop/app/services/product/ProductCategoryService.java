package memol.shop.app.services.product;

import memol.shop.app.entities.products.Product;
import memol.shop.app.entities.products.ProductCategory;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.repositories.product.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;
    @Autowired
    private ProductService productService;


    public List<ProductCategory> findAllOrderByItemOrder( ){

        return repository.findAllByEnableIsTrue(Sort.by("id"));
    }
    public ProductCategory getByID(long id){
       Optional<ProductCategory> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
    public List<ProductCategory> getAll(Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize,Sort.by("id"));
        Page<ProductCategory> all=repository.findAll(page);
        return all.toList();
    }
    public long getAllCount(){
        return repository.count();
    }

    public ProductCategory add(ProductCategory data){
        return repository.save(data);
    }
    public ProductCategory update(ProductCategory data) throws DataNotFoundExeption {
        ProductCategory oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setEnable(data.isEnable());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws Exception {
        ProductCategory oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }

        List<Product> productList= productService.findAllOrderByCategory(id);
        if (productList.size()>0){
            throw new Exception("please delete products in this category at first");
        }
        repository.deleteById(id);
        return true;
    }
}
