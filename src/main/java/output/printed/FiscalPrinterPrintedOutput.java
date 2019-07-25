package output.printed;

import shoppingCart.ShoppingCart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FiscalPrinterPrintedOutput implements PrintedOutput {

    @Override
    public  void print(ShoppingCart cart) {
        try {
            BufferedWriter receiptWriter = new BufferedWriter(new FileWriter("ShoppingCart" + cart.getId() + ".txt"));
            receiptWriter.write(cart.toString());
            receiptWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
