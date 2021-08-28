public class UserDoesNotExistException extends Throwable {
    public UserDoesNotExistException() {
        this("");
    }

    public UserDoesNotExistException(String message) {
        super(message,null);
    }

    public UserDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDoesNotExistException(Throwable cause) {
        super(null,cause);
    }
}
