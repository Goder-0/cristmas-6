package christmas.model.benefit;

import christmas.Constants;
import christmas.model.order.Order;
import java.time.LocalDate;
import java.util.List;

public class ChristmasDiscount extends Benefit {

    public ChristmasDiscount() {
        super("크리스마스 디데이 할인");
    }

    @Override
    protected boolean isBenefitAble(LocalDate date, List<Order> orders) {
        return date.isBefore(Constants.EVENT_CHRISTMAS_DATE_END);
    }

    @Override
    public void update(LocalDate date, List<Order> orders) {
        amount = date.getDayOfMonth() * 100 + 900;
    }
}
