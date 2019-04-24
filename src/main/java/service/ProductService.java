package service;

import exceptions.EnitytNotFoundException;
import model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id) throws EnitytNotFoundException;
    Product create(Product product);
    Product getProductToAdd(Long barcode, ProductService productService) throws EnitytNotFoundException;
}
