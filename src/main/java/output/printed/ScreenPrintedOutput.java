package output.printed;

import shoppingCart.ShoppingCart;

public class ScreenPrintedOutput implements PrintedOutput {

    @Override
    public void print(ShoppingCart cart) {
        System.out.println(cart.toString());
    }

}
