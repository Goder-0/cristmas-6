package christmas.model.benefit;

import christmas.Constants;
import christmas.model.menu.MenuGroup;
import christmas.model.order.Order;
import java.time.LocalDate;
import java.util.List;

public abstract class Benefit {
    private final String name;
    protected long amount = 0;
    protected long totalPrice = 0;

    public Benefit(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public String toString() {
        return String.format("%s: -%,d원", name, amount);
    }

    public boolean isAble(LocalDate date, List<Order> orders) {
        totalPrice = 0;
        for (Order order : orders) {
            totalPrice += order.getPrice();
        }
        List<MenuGroup> menuGroups = MenuGroup.findGroupsByOrders(orders);
        if (totalPrice < Constants.MIN_PRICE || menuGroups.equals(List.of(MenuGroup.Drink))) {
            return false;
        }
        return isBenefitAble(date, orders);
    }

    protected abstract boolean isBenefitAble(LocalDate date, List<Order> orders);

    public abstract void update(LocalDate date, List<Order> orders);
}
