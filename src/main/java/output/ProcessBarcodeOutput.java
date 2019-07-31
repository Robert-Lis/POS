package output;

import exceptions.EntityNotFoundByBarcodeException;
import product.Product;
import product.ProductServiceStubImpl;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingCartServiceStubImpl;

public class ProcessBarcodeOutput {


    public static ShoppingCart getOutput(String input, ShoppingCart cart) throws EntityNotFoundByBarcodeException {
        ProductServiceStubImpl productService = new ProductServiceStubImpl();
        ShoppingCartServiceStubImpl shoppingCartService = new ShoppingCartServiceStubImpl();

        Product product = productService.getProductByBarcode(Integer.valueOf(input));

        shoppingCartService.addProductToShoppingCart(product, cart);

        return cart;
    }
}
