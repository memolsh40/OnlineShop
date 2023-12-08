package memol.shop.app.helper.ui.uimodels;

import memol.shop.app.entities.products.Product;

import java.util.List;

public class ProductVM {
    private long id;
    private String title;
    private String description;
    private String image;
    private long price;
    private boolean enable;
    private boolean exists;
    private long categoryId;
    private List<Long> colors;
    private List<Long> sizes;
    private List<Long> features;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Long> getColors() {
        return colors;
    }

    public void setColors(List<Long> colors) {
        this.colors = colors;
    }

    public List<Long> getSizes() {
        return sizes;
    }

    public void setSizes(List<Long> sizes) {
        this.sizes = sizes;
    }

    public List<Long> getFeatures() {
        return features;
    }

    public void setFeatures(List<Long> features) {
        this.features = features;
    }

    public ProductVM() {
    }
    public Product convert(){
        Product product=new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImage(getImage());
        product.setEnable(isEnable());
        product.setExists(isExists());
        return product;
    }
}
