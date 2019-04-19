package model;

import java.time.LocalDateTime;
import java.util.List;

public class Receipt {

    private Long id;
    private List<Product> products;
    private LocalDateTime timeOfPrinting;


    public Receipt() {
    }

    public Receipt(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeOfPrinting(LocalDateTime timeOfPrinting) {
        this.timeOfPrinting = timeOfPrinting;
    }
}
