package output.console;

import shoppingCart.ShoppingCartData;

import java.util.Scanner;

public interface Output {

    ShoppingCartData getOutput(ShoppingCartData shoppingCartData, Scanner scanner);
}
