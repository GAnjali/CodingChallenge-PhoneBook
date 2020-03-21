package exceptions;

import static constants.PhoneBookConstants.NO_ARGS_FOUND_MESSAGE;

public class NoArgumentException extends Exception {
    private final String message;

    public NoArgumentException() {
        super();
        this.message = NO_ARGS_FOUND_MESSAGE;
    }

    @Override
    public String toString() {
        return message;
    }
}
