package exceptions;


public class EnitytNotFoundException extends Throwable {

    public EnitytNotFoundException(Class cls, Long id) {
        System.out.println("The " + cls.getSimpleName() + "with id: " + id + " does not exist");
    }
}
