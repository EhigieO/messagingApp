public class UserAlreadyExistException extends Throwable{
    public UserAlreadyExistException() {
        this("");
    }

    public UserAlreadyExistException(String message) {
        super(message, null);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(Throwable cause) {
        super("",cause);
    }
}
