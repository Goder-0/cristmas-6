package christmas.view.inputview;

import christmas.exception.DateException;
import front.model.Model;
import front.view.Viewable;
import java.time.LocalDate;

public class DateInputView extends InputView implements Viewable {
    @Override
    Object read(String input) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new DateException();
        }
        if (number < 0 || number > 31) {
            throw new DateException();
        }
        return LocalDate.of(2023, 12, number);
    }

    @Override
    void printMessage() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    @Override
    public void render(Model model) {
        model.add("date", readElseRepeat());
    }
}
