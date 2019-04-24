package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private Long id;
    private List<Product> products;
    private LocalDateTime timeOfPrinting;


    public Receipt() {
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
        return "Receipt{" +
                "id=" + id +
                ", products=" + products +
                ", timeOfPrinting=" + timeOfPrinting +
                '}';
    }
}
