package utilities;

import exceptions.EntityNotFoundByBarcodeException;
import exceptions.ProductNotExistedException;
import input.ProcessInput;

public class Application {

    public static void start() throws EntityNotFoundByBarcodeException, ProductNotExistedException {
        getInput();
    }


    private static void getInput() throws EntityNotFoundByBarcodeException, ProductNotExistedException {
        ProcessInput processInput = new ProcessInput();
        processInput.getInput();
    }
}
