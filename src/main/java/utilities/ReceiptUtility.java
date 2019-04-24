package utilities;

import model.Product;
import model.Receipt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class ReceiptUtility {


    public String print(Receipt receipt) {
        BigDecimal receiptSum = BigDecimal.ZERO;
        StringBuilder receiptText = new StringBuilder();
        String newLine = System.getProperty("line.separator");


        receiptText.append("Receipt no.: ").append(receipt.getId()).append(newLine);
        for (Product product : receipt.getProducts()){
            receiptText.append(product.getName()).append(", price: ").append(product.getPriceAsString()).append(newLine);
            receiptSum = receiptSum.add(product.getPrice());
        }
        receiptText.append("Total sum is: ").append(MainUtility.df2.format(receiptSum));


        return receiptText.toString();
    }


    public void printToFile(Long receiptId, String receiptText) {
        try {
            BufferedWriter receiptWriter = new BufferedWriter(new FileWriter("Receipt" + receiptId + ".txt"));
            receiptWriter.write(receiptText);

            receiptWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void printToConsole(String receiptText) {
        System.out.println(receiptText);
    }
}
