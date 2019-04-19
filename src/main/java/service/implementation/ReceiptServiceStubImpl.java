package service.implementation;

import model.Receipt;
import service.ReceiptService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReceiptServiceStubImpl implements ReceiptService {

    private List<Receipt> receipts = new ArrayList<>();


    @Override
    public List<Receipt> findAll() {
        return this.receipts;
    }

    @Override
    public Optional<Receipt> findById(Long id) {
        return this.receipts.stream()
                .filter(r -> Objects.equals(r.getId(), id))
                .findFirst();
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
    public String printById(Long id) {
        return findById(id).toString();
    }
}
