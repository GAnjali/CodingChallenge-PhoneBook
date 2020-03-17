package exceptions;

public class NoSuchFileFoundException extends Exception {
    private final String message;

    public NoSuchFileFoundException() {
        super();
        this.message = "No Such File found, Please provide proper file name";
    }

    @Override
    public String toString() {
        return message;
    }
}
