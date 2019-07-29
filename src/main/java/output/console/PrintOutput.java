package output.console;

import output.printed.FiscalPrinterPrintedOutput;
import output.printed.ScreenPrintedOutput;
import shoppingCart.ShoppingCart;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PrintOutput implements Output{


    @Override
    public void getOutput(ShoppingCart cart, Scanner scanner) {
        cart.setTimeOfPrinting(LocalDateTime.now());

        ScreenPrintedOutput screenOutput = new ScreenPrintedOutput();
        screenOutput.print(cart);

        FiscalPrinterPrintedOutput fiscalOutput = new FiscalPrinterPrintedOutput();
        fiscalOutput.print(cart);
    }
}
