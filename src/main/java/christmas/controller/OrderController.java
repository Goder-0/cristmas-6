package christmas.controller;

import front.model.Model;
import christmas.model.order.Order;
import christmas.service.ChristmasService;
import java.util.List;

public class OrderController implements Controllable {
    private final ChristmasService christmasService;

    public OrderController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        List<Order> orders = (List<Order>) (model.get("orders"));
        christmasService.orderMenus(orders);
        return "";
    }
}
