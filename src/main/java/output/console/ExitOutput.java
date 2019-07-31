package output.console;

import shoppingCart.ShoppingCartData;

import java.util.Scanner;

public class ExitOutput implements Output {

    @Override
    public ShoppingCartData getOutput(ShoppingCartData shoppingCartData, Scanner scanner) {
        System.out.println("Goodbye!");
        scanner.close();
        return shoppingCartData;
    }
}
