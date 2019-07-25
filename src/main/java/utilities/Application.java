package utilities;

import exceptions.EntityNotFoundByBarcodeException;
import exceptions.ProductNotExistedException;
import input.ProcessInput;
import product.ProductServiceStubImpl;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingCartServiceStubImpl;

public class Application {

    public static void start() throws ProductNotExistedException, EntityNotFoundByBarcodeException {
        initDb();
        ShoppingCart shoppingCart = createFirstShoppingCart();
        getInput(shoppingCart);
    }


    private static void initDb() throws ProductNotExistedException {
        ProductServiceStubImpl productService = new ProductServiceStubImpl();
        productService.dbInit();
    }

    private static ShoppingCart createFirstShoppingCart() {
        ShoppingCartServiceStubImpl shoppingCartService = new ShoppingCartServiceStubImpl();
        return shoppingCartService.getNewShoppingCart();
    }

    private static void getInput(ShoppingCart shoppingCart) throws EntityNotFoundByBarcodeException {
        ProcessInput processInput = new ProcessInput();
        processInput.getInput(shoppingCart);
    }
}
