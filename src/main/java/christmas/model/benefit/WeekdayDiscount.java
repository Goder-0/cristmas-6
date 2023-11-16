package christmas.model.benefit;

import christmas.Constants;
import christmas.model.menu.MenuGroup;
import christmas.model.order.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class WeekdayDiscount extends Benefit {

    public WeekdayDiscount() {
        super("평일 할인");
    }

    @Override
    protected boolean isBenefitAble(LocalDate date, List<Order> orders) {
        if (date.getDayOfWeek().getValue() <= DayOfWeek.TUESDAY.getValue()) {
            return checkDessert(orders);
        }
        return false;
    }

    @Override
    public void update(LocalDate date, List<Order> orders) {
        long count = MenuGroup.findGroupsByOrders(orders).stream()
                .filter(menuGroup -> menuGroup == MenuGroup.Dessert)
                .count();
        amount = count * Constants.THIS_YEAR;
    }

    private boolean checkDessert(List<Order> orders) {
        return MenuGroup.findGroupsByOrders(orders).contains(MenuGroup.Dessert);
    }

}
