package exceptions;

public class UniversityWithoutFacultyException extends Exception {
    public UniversityWithoutFacultyException() {
        super();
    }

    public UniversityWithoutFacultyException(String message) {
        super(message);
    }

    public UniversityWithoutFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityWithoutFacultyException(Throwable cause) {
        super(cause);
    }
}
