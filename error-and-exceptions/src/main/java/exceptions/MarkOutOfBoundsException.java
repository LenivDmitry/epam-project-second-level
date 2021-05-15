package exceptions;

public class MarkOutOfBoundsException extends Exception {
    public MarkOutOfBoundsException() {
        super();
    }

    public MarkOutOfBoundsException(String message) {
        super(message);
    }

    public MarkOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}
