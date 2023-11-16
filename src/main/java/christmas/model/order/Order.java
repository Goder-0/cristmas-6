package christmas.model.order;

import christmas.Constants;
import christmas.exception.MenuException;
import christmas.model.menu.Menu;

public class Order {

    private final Menu menu;
    private final Integer count;

    public Order(Menu menu, Integer count) {
        this.menu = menu;
        this.count = count;
        validator();
    }

    public Menu getMenu() {
        return menu;
    }

    public Long getPrice() {
        return menu.getPrice() * count;
    }

    public void validator() {
        if (count < Constants.MIN_MENU_COUNT) {
            throw new MenuException();
        }
    }

    public String toString() {
        if (menu != Menu.Empty) {
            return String.format("%s %d개", menu.getName(), count);
        }
        return menu.getName();
    }

    public boolean isEmpty() {
        return menu == Menu.Empty;
    }
}
