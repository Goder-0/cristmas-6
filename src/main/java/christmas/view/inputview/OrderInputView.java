package christmas.view.inputview;

import christmas.Constants;
import christmas.exception.MenuException;
import front.model.Model;
import christmas.model.order.Order;
import christmas.model.menu.Menu;
import front.view.Viewable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderInputView extends InputView implements Viewable {
    @Override
    Object read(String input) throws IllegalArgumentException {
        List<String[]> list = Arrays.stream(input.split(Constants.SPLITTER_MENU))
                .map(s -> s.split(Constants.SPLITTER_MENU_COUNT))
                .toList();
        List<Order> orders = new ArrayList<>();
        for (String[] menuCount : list) {
            Menu menu = Menu.findByName(menuCount[0]);
            Integer count = numberValidate(menuCount[1]);
            Order order = new Order(menu, count);
            orders.add(order);
        }
        return orders;
    }

    @Override
    void printMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    @Override
    public void render(Model model) {
        model.add("orders", readElseRepeat());
    }

    private Integer numberValidate(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new MenuException();
        }
    }
}
