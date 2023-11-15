package christmas.exception;

public class DateException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return ErrorMessages.Date.getMessage();
    }
}
