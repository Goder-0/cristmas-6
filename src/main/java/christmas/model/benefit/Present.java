package christmas.model.benefit;

import christmas.Constants;
import christmas.model.menu.Menu;
import christmas.model.order.Order;
import java.time.LocalDate;
import java.util.List;

public class Present extends Benefit {
    private final Order order = new Order(Menu.Champagne, 1);

    public Present() {
        super("증정 이벤트");
    }

    public Order getOrder() {
        return order;
    }

    @Override
    protected boolean isBenefitAble(LocalDate date, List<Order> orders) {
        return totalPrice >= Constants.PRESENT_PRICE;
    }

    @Override
    public void update(LocalDate date, List<Order> orders) {
        amount = order.getPrice();
    }
}
