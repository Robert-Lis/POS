package output.console;

import shoppingCart.ShoppingCart;

import java.util.Scanner;

public class ExitOutput implements Output {

    @Override
    public void getOutput(ShoppingCart cart, Scanner scanner) {
        System.out.println("Goodbye!");
        scanner.close();
    }
}
