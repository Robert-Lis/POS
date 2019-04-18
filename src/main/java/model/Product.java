package model;

public class Product {

    private Long id;
    private Long barcode;
    private String name;

    public Product() {
    }

    public Product(Long id, Long barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }
}
