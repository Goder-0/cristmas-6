package christmas.controller;

import christmas.Constants;
import christmas.model.benefit.Benefit;
import christmas.service.ChristmasService;
import front.model.Model;
import java.util.List;

public class BenefitDetailController implements Controllable {
    private final ChristmasService christmasService;

    public BenefitDetailController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        List<Benefit> benefits = christmasService.getBenefits();
        model.add("benefits", benefits);
        return Constants.VIEW_BENEFIT_DETAIL;
    }
}
