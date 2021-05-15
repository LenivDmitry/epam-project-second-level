package exceptions;

public class GroupWithoutStudentException extends Exception {
    public GroupWithoutStudentException() {
        super();
    }

    public GroupWithoutStudentException(String message) {
        super(message);
    }

    public GroupWithoutStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupWithoutStudentException(Throwable cause) {
        super(cause);
    }
}
