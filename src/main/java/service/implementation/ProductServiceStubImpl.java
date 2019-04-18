package service.implementation;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductServiceStubImpl implements ProductService {

    private List<Product> allExistingProducts = new ArrayList<>();


    @Override
    public List<Product> findAll() {
        return this.allExistingProducts;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.allExistingProducts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst();
    }

    @Override
    public Product create(Product product) {
        if (allExistingProducts.size() == 0){
            product.setId(1L);
        } else {
            Product lastAddedProduct = allExistingProducts.get(allExistingProducts.size() - 1);
            product.setId(lastAddedProduct.getId() + 1);
        }
        this.allExistingProducts.add(product);
        return product;
    }
}
