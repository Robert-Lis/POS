package product;

import exceptions.EntityNotFoundByBarcodeException;
import exceptions.ProductNotExistedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceStubImpl implements ProductService{

    private static List<Product> products = new ArrayList<>();


    public ProductServiceStubImpl() {
    }

    public void dbInit() throws ProductNotExistedException {

        products.add(new Product(123456789, "Shoes", new BigDecimal(22.99)));
        products.add(new Product(123456788, "Coat", new BigDecimal(22.99)));
        products.add(new Product(123456787, "Jeans", new BigDecimal(22.99)));
        products.add(new Product(123456786, "T-shirt", new BigDecimal(22.99)));
        products.add(new Product(123456785, "Gloves", new BigDecimal(22.99)));

        System.out.println("Product database initialized.");
    }


    public List<Product> getAll() {
        return this.products;
    }

    public Product getProductByBarcode(Integer barcode) throws EntityNotFoundByBarcodeException {
        try{
            return this.products.stream()
                    .filter(p -> barcode.equals(p.getBarcode()))
                    .findFirst()
                    .orElseThrow(() -> new EntityNotFoundByBarcodeException(Product.class, barcode));
        } catch(NullPointerException exception){
            throw new EntityNotFoundByBarcodeException(Product.class, barcode);
        }

    }

    public Product addProduct(Product product) throws ProductNotExistedException {
        try {
            product = setIdForNewProduct(product);
            products.add(product);
            System.out.println("New product added: " + product.getId() + ", " + product.getName());
        } catch (NullPointerException exception){
            throw new ProductNotExistedException();
        }
        return product;
    }


    public void clear(){
        products = new ArrayList<>();
    }




    private static Product setIdForNewProduct(Product product) {
        if (products.size() == 0){
            product.setId(Long.valueOf(1));
        }
        if (products.size() > 0){
            Long lastAddedProductID = products.get(products.size() - 1).getId();
            product.setId(lastAddedProductID);
        }
        return product;
    }



}
