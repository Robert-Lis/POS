import exceptions.EntityNotFoundByBarcodeException;
import exceptions.ProductNotExistedException;
import utilities.Application;

public class Main {


    public static void main(String[] args) throws EntityNotFoundByBarcodeException, ProductNotExistedException {

        Application.start();
    }
}
