package product;

import exceptions.EntityNotFoundByBarcodeException;
import exceptions.ProductNotExistedException;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getProductByBarcode(Integer barcode) throws EntityNotFoundByBarcodeException;
    Product addProduct(Product product) throws ProductNotExistedException;
}
