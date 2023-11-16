package christmas.controller;

import christmas.Constants;
import christmas.service.ChristmasService;
import front.model.Model;

public class TotalPriceController implements Controllable {
    private final ChristmasService christmasService;

    public TotalPriceController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        Long totalPrice = christmasService.getTotalPrice();
        model.add("totalPrice", totalPrice);
        return Constants.VIEW_TOTAL_PRICE;
    }
}
