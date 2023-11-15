package christmas.view.inputview;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {

    public Object readElseRepeat() {
        printMessage();
        while (true) {
            try {
                String input = Console.readLine();
                validator(input);
                return read(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    abstract Object read(String input) throws IllegalArgumentException;

    abstract void printMessage();

    private void validator(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBlank(String input) {
        return input.isBlank();
    }
}
