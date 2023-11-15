package christmas.controller;

import christmas.Constants;
import christmas.model.order.Order;
import christmas.service.ChristmasService;
import front.model.Model;

public class PresentController implements Controllable {
    private final ChristmasService christmasService;

    public PresentController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        Order present = christmasService.checkPresent();
        model.add("present", present);
        return Constants.VIEW_PRESENT;
    }
}
