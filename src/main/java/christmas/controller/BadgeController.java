package christmas.controller;

import christmas.Constants;
import christmas.model.badge.Badge;
import christmas.service.ChristmasService;
import front.model.Model;

public class BadgeController implements Controllable {
    private final ChristmasService christmasService;

    public BadgeController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        Badge badge = christmasService.checkBadge();
        model.add("badge", badge.toString());
        return Constants.VIEW_BADGE;
    }
}
