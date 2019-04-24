package service.implementation;

import exceptions.EnitytNotFoundException;
import model.Product;
import service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductServiceStubImpl implements ProductService{

    private List<Product> products = new ArrayList<>();

    public ProductServiceStubImpl() {
    }

    public void addProducts(){
        create(new Product(1, "Shoes", new BigDecimal(22.99)));
        create(new Product(2, "Coat", new BigDecimal(56.99)));
        create(new Product(3, "Jeans", new BigDecimal(10.99)));
        create(new Product(4, "T-shirt", new BigDecimal(2.99)));
        create(new Product(123456785, "Gloves", new BigDecimal(8.99)));
    }


    @Override
    public List<Product> findAll() {
        return this.products;
    }

    @Override
    public Product findById(Long id) throws EnitytNotFoundException {
        return this.products.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElseThrow(() -> new EnitytNotFoundException(Product.class, id));
    }

    @Override
    public Product create(Product product) {
        Long first = Long.valueOf(1);

        if (products.size() == 0){
            product.setId(first);
        } else {
            Product lastAddedProduct = products.get(products.size() - 1);
            product.setId(lastAddedProduct.getId() + 1);
        }
        this.products.add(product);
        return product;
    }

    @Override
    public Product getProductToAdd(Long barcode, ProductService productService) throws EnitytNotFoundException {
        return productService.findById(barcode);
    }


}
