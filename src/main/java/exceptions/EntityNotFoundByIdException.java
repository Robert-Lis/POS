package exceptions;

public class EntityNotFoundByIdException extends Throwable{

    public EntityNotFoundByIdException(Class cls, Long id) {
        System.out.println("The " + cls.getSimpleName() + "with id: " + id + " does not exist");
    }
}
