package christmas.exception;

public enum ErrorMessages {
    Date("유효하지 않은 날짜입니다."),
    Menu("유효하지 않은 주문입니다.");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message + " 다시 입력해 주세요.";
    }
}
