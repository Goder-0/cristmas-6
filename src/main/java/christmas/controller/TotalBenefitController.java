package christmas.controller;

import christmas.Constants;
import christmas.service.ChristmasService;
import front.model.Model;

public class TotalBenefitController implements Controllable {
    private final ChristmasService christmasService;

    public TotalBenefitController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        Long totalBenefitPrice = christmasService.calculateBenefitPrice();
        model.add("totalBenefitPrice", totalBenefitPrice);
        return Constants.VIEW_TOTAL_BENEFIT;
    }
}
