package christmas.controller;

import christmas.Constants;
import christmas.model.order.Order;
import christmas.service.ChristmasService;
import front.model.Model;
import java.util.List;

public class OrderDetailController implements Controllable {
    private final ChristmasService christmasService;

    public OrderDetailController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        List<Order> orders = christmasService.getOrders();
        model.add("orders", orders);
        return Constants.VIEW_ORDER_DETAIL;
    }
}
