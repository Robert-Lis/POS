package product;

import utilities.DecimalFormatter;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private Integer barcode;
    private String name;
    private BigDecimal price;


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

    public int getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return "Product:\n" +
                " id: " + id +
                ", barcode: " + barcode +
                ", name: '" + name + '\'' +
                ", price: " + DecimalFormatter.decimalFormat2.format(price) +
                '\n';
    }

}
