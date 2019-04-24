package service;

import exceptions.EnitytNotFoundException;
import model.Product;
import model.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> findAll();
    Receipt findById(Long id) throws EnitytNotFoundException;
    Receipt create(Receipt receipt);
    void printById(Receipt receipt);
    void addProduct(Product productToAdd, Receipt receipt);

}
