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


    @Override
    public String toString() {
        return "ShoppingCart" + id + "\n" +
                products + "\n" +
                "TimeOfPrinting: " + DateFormatter.dateFormatter(timeOfPrinting);
    }
}
