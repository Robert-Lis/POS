package output.console;

import output.printed.FiscalPrinterPrintedOutput;
import output.printed.ScreenPrintedOutput;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingCartData;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PrintOutput implements Output{


    @Override
    public ShoppingCartData getOutput(ShoppingCartData shoppingCartData, Scanner scanner) {
        ShoppingCart activeCart = shoppingCartData.getCart();
        activeCart.setTimeOfPrinting(LocalDateTime.now());

        printScreenOutput(activeCart);

        printPrintedOutput(activeCart);

        return getNewShoppingCart(shoppingCartData);
    }


    private void printScreenOutput(ShoppingCart cart) {
        ScreenPrintedOutput screenOutput = new ScreenPrintedOutput();
        screenOutput.print(cart);
    }

    private void printPrintedOutput(ShoppingCart cart) {
        FiscalPrinterPrintedOutput fiscalOutput = new FiscalPrinterPrintedOutput();
        fiscalOutput.print(cart);
    }

    private ShoppingCartData getNewShoppingCart(ShoppingCartData shoppingCartData) {
        shoppingCartData.setNewShoppingCart();
        return shoppingCartData;
    }
}
