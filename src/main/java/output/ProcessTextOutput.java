package output;

import output.console.Output;
import shoppingCart.ShoppingCartData;

import java.util.Scanner;

public class ProcessTextOutput {


    public static ShoppingCartData getOutput(String input, ShoppingCartData shoppingCartData, Scanner scanner) {
        Output output = TextOutputs.get(input);
        return output.getOutput(shoppingCartData, scanner);
    }
}
