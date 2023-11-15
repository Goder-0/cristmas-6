package christmas.model.benefit;

import christmas.Constants;
import christmas.model.menu.MenuGroup;
import christmas.model.order.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class WeekendDiscount extends Benefit {
    public WeekendDiscount() {
        super("주말 할인");
    }

    @Override
    protected boolean isBenefitAble(LocalDate date, List<Order> orders) {
        if (DayOfWeek.FRIDAY.getValue() <= date.getDayOfWeek().getValue()) {
            return checkMain(orders);
        }
        return false;
    }

    @Override
    public void update(LocalDate date, List<Order> orders) {
        long count = MenuGroup.findGroupsByOrders(orders).stream()
                .filter(menuGroup -> menuGroup == MenuGroup.MainDish)
                .count();
        amount = count * Constants.THIS_YEAR;
    }

    public boolean checkMain(List<Order> orders) {
        return MenuGroup.findGroupsByOrders(orders).contains(MenuGroup.MainDish);
    }
}
