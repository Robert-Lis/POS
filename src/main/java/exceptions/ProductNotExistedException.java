package exceptions;

public class ProductNotExistedException extends Throwable {

    public ProductNotExistedException() {
        System.out.println("When you add Product can't be a null!");
    }

    @Override
    public String getMessage() {
        return "Product which you are adding, can't be a null!";
    }
}
