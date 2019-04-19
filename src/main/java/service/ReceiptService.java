package service;

import model.Receipt;

import java.util.List;
import java.util.Optional;

public interface ReceiptService {

    List<Receipt> findAll();
    Optional<Receipt> findById(Long id);
    Receipt create(Receipt receipt);
    String printById(Long id);

}
