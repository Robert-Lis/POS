package model;

import utilities.MainUtility;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private int barcode;
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(int barcode, String name, BigDecimal price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPriceAsString() {
        return MainUtility.df2.format(price);
    }

    public BigDecimal getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", name='" + name + '\'' +
                ", price=" + MainUtility.df2.format(price) +
                '}';
    }
}
