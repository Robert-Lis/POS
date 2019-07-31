package input;


import exceptions.EntityNotFoundByBarcodeException;
import exceptions.ProductNotExistedException;
import output.ProcessBarcodeOutput;
import output.ProcessTextOutput;
import product.ProductServiceStubImpl;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingCartData;
import shoppingCart.ShoppingCartServiceStubImpl;

import java.util.Scanner;

public class ProcessInput {
    ProductServiceStubImpl productService = new ProductServiceStubImpl();
    ShoppingCartServiceStubImpl shoppingCartService = new ShoppingCartServiceStubImpl();

    public ProcessInput() throws ProductNotExistedException {
        this.productService.dbInit();
    }


    public void getInput() throws EntityNotFoundByBarcodeException {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart activeCart = shoppingCartService.getNewShoppingCart();

        while(scanner.hasNext()){
            String input = scanner.nextLine();
            //TODO: zastanowić się, czy metoda nie ma dwóch odpowiedzialności pobieranie i przekazywanie (to chyba ok) oraz trim(?)
            activeCart = processInput(input.trim().toLowerCase(), activeCart, scanner);
        }
    }



    private ShoppingCart processInput(String input, ShoppingCart cart, Scanner scanner) throws EntityNotFoundByBarcodeException {
        ShoppingCart activeCart = cart;

        if(!VerifyInput.verify(input)){
            System.out.println("Sorry, wrong input");
        }
        if(VerifyInput.ifExitOrPrintInput(input)){
            ShoppingCartData shoppingCartData = new ShoppingCartData(activeCart, shoppingCartService);

            activeCart = ProcessTextOutput.getOutput(input, shoppingCartData, scanner).getCart();
        }
        if(VerifyInput.ifBarcodeInput(input)){
            activeCart = ProcessBarcodeOutput.getOutput(input, activeCart);
        }

        return activeCart;
    }
}
