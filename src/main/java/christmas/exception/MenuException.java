package christmas.exception;

public class MenuException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return ErrorMessages.Menu.getMessage();
    }
}
