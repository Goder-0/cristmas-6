package christmas.controller;

import christmas.Constants;
import christmas.service.ChristmasService;
import front.model.Model;

public class ExpectPriceController implements Controllable {
    private final ChristmasService christmasService;

    public ExpectPriceController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        Long expectedPrice = christmasService.calculateExpectedPrice();
        model.add("expectPrice", expectedPrice);
        return Constants.VIEW_EXPECT_PRICE;
    }
}
