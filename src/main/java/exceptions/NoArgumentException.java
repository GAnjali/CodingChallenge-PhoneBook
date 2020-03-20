package exceptions;

public class NoArgumentException extends Exception {
    private final String message;

    public NoArgumentException() {
        super();
        this.message = "No Command line Arguments Provided, Provide resources";
    }

    @Override
    public String toString() {
        return message;
    }
}
