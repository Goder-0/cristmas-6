package christmas.model.benefit;

import christmas.model.order.Order;
import java.time.LocalDate;
import java.util.List;

public class SpecialDiscount extends Benefit {
    private final List<Integer> startDates = List.of(
            3, 10, 17, 24, 25, 31
    );

    public SpecialDiscount() {
        super("특별 할인");
    }

    @Override
    protected boolean isBenefitAble(LocalDate date, List<Order> orders) {
        return startDates.contains(date.getDayOfMonth());
    }

    @Override
    public void update(LocalDate date, List<Order> orders) {
        amount = 1000;
    }
}
