package exceptions;

public class FacultyWithoutGroupException extends Exception {
    public FacultyWithoutGroupException() {
        super();
    }

    public FacultyWithoutGroupException(String message) {
        super(message);
    }

    public FacultyWithoutGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultyWithoutGroupException(Throwable cause) {
        super(cause);
    }
}
