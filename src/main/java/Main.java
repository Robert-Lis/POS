import exceptions.EnitytNotFoundException;
import model.Product;
import model.Receipt;
import service.ProductService;
import service.ReceiptService;
import service.implementation.ProductServiceStubImpl;
import service.implementation.ReceiptServiceStubImpl;
import utilities.MainUtility;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws EnitytNotFoundException {
        String printReceiptText = "exit";
        String exitTheProgram = "quit";
        Scanner scanner = new Scanner(System.in);

        ProductService productService = new ProductServiceStubImpl();
        ((ProductServiceStubImpl) productService).addProducts();

        ReceiptService receiptService = new ReceiptServiceStubImpl();

        MainUtility mainUtility = new MainUtility();

        Receipt receipt = receiptService.create(new Receipt());

        while(scanner.hasNext()) {
            String scannedText = scanner.nextLine();

            if (scannedText.toLowerCase().equals(exitTheProgram)){
                System.out.println("Goodbye!");
                scanner.close();
            } else if (scannedText.isEmpty() || scannedText.equals("")) {
                System.out.println("Invalid bar-code");
                //ToDo: not finished (manage empty / whitespace input

            } else {
                if (scannedText.toLowerCase().equals(printReceiptText)) {
                    receiptService.printById(receipt);
                    receipt = receiptService.create(new Receipt());

                } else {
                    //ToDo: below code to refactor
                    if (mainUtility.verifyInput(scannedText)){
                        try{
                            Product getProductToAdd = productService.getProductToAdd(Long.valueOf(scannedText), productService);
                            receiptService.addProduct(getProductToAdd, receipt);
                        } catch (EnitytNotFoundException e){

                        }
                    }
                }
            }
        }
    }
}
