package shoppingCart;

import product.Product;
import utilities.DateFormatter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private Long id;
    private List<Product> products;
    private LocalDateTime timeOfPrinting;


    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setTimeOfPrinting(LocalDateTime timeOfPrinting) {
        this.timeOfPrinting = timeOfPrinting;
    }

    public String getAllProductsAsString(){
        StringBuilder allProductsBuilder = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            allProductsBuilder.append(i+1).append(products.get(i));
        }
        return allProductsBuilder.toString();
    }

    @Override
    public String toString() {
        return "Shopping cart " + id + "\n" +
                "Time of printing: " + DateFormatter.dateFormatter(timeOfPrinting) + "\n" +
                getAllProductsAsString();
    }
}
