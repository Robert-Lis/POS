package output;

import output.console.Output;
import shoppingCart.ShoppingCart;

import java.util.Scanner;

public class ProcessTextOutput {


    public static void getOutput(String input, ShoppingCart cart, Scanner scanner) {
        Output output = TextOutputs.get(input);
        output.getOutput(cart, scanner);
    }
}
