package service.implementation;

import exceptions.EnitytNotFoundException;
import model.Product;
import model.Receipt;
import service.ReceiptService;
import utilities.ReceiptUtility;

import java.time.LocalDateTime;
import java.util.*;

public class ReceiptServiceStubImpl implements ReceiptService {

    private List<Receipt> receipts = new ArrayList<>();
    ReceiptUtility receiptUtility = new ReceiptUtility();

    @Override
    public List<Receipt> findAll() {
        return this.receipts;
    }

    @Override
    public Receipt findById(Long id) throws EnitytNotFoundException {
        return this.receipts.stream()
                .filter(r -> Objects.equals(r.getId(), id))
                .findFirst()
                .orElseThrow(() -> new EnitytNotFoundException(Receipt.class, id));
    }

    @Override
    public Receipt create(Receipt receipt) {
        if (receipts.size() == 0){
            receipt.setId(1L);
        } else {
            Receipt lastAddedReceipt = receipts.get(receipts.size() - 1);
            receipt.setId(lastAddedReceipt.getId() + 1);
        }
        this.receipts.add(receipt);
        return receipt;
    }


    @Override
    public void printById(Receipt receipt){
        LocalDateTime currentDate = LocalDateTime.now();
        receipt.setTimeOfPrinting(currentDate);
        String receiptText;

        receiptText = receiptUtility.print(receipt);
        receiptUtility.printToFile(receipt.getId(), receiptText);
        receiptUtility.printToConsole(receiptText);
    }

    @Override
    public void addProduct(Product productToAdd, Receipt receipt) {
        receipt.addProduct(productToAdd);
        System.out.println("Product: " + productToAdd.getName() + " added.");
    }


}
