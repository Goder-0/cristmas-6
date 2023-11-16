package christmas.controller;

import christmas.service.ChristmasService;
import front.model.Model;
import java.time.LocalDate;

public class DateController implements Controllable {
    private final ChristmasService christmasService;

    public DateController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    @Override
    public String process(Model model) {
        LocalDate date = (LocalDate) model.get("date");
        christmasService.selectPurchaseDate(date);
        return "";
    }
}
