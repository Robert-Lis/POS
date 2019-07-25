package exceptions;

public class EntityNotFoundByBarcodeException extends Throwable {

    public EntityNotFoundByBarcodeException(Class cls, Integer barcode) {
        System.out.println("The " + cls.getSimpleName() + " with barcode: " + barcode + " does not exist");
    }

    @Override
    public String getMessage() {
        return "Product with this barcode does not exist";
    }
}
