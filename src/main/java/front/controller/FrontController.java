package front.controller;

import christmas.Constants;
import christmas.controller.BadgeController;
import christmas.controller.BenefitDetailController;
import christmas.controller.Controllable;
import christmas.controller.DateController;
import christmas.controller.ExpectPriceController;
import christmas.controller.OrderController;
import christmas.controller.OrderDetailController;
import christmas.controller.PresentController;
import christmas.controller.TotalBenefitController;
import christmas.controller.TotalPriceController;
import christmas.service.ChristmasService;
import christmas.view.inputview.InputView;
import front.model.Model;
import front.view.ViewFactory;
import front.view.ViewModel;
import front.view.Viewable;
import java.util.List;
import java.util.TreeMap;

public class FrontController {
    private final TreeMap<String, Controllable> controllers;
    private final List<String> views = List.of(
            Constants.VIEW_DATE,
            Constants.VIEW_ORDER,
            Constants.VIEW_ORDER_DETAIL,
            Constants.VIEW_TOTAL_PRICE,
            Constants.VIEW_PRESENT,
            Constants.VIEW_BENEFIT_DETAIL,
            Constants.VIEW_TOTAL_BENEFIT,
            Constants.VIEW_EXPECT_PRICE,
            Constants.VIEW_BADGE
    );

    public FrontController() {
        ChristmasService christmasService = new ChristmasService();
        controllers = new TreeMap<>() {{
            put(Constants.VIEW_DATE, new DateController(christmasService));
            put(Constants.VIEW_ORDER, new OrderController(christmasService));
            put(Constants.VIEW_ORDER_DETAIL, new OrderDetailController(christmasService));
            put(Constants.VIEW_TOTAL_PRICE, new TotalPriceController(christmasService));
            put(Constants.VIEW_PRESENT, new PresentController(christmasService));
            put(Constants.VIEW_BENEFIT_DETAIL, new BenefitDetailController(christmasService));
            put(Constants.VIEW_TOTAL_BENEFIT, new TotalBenefitController(christmasService));
            put(Constants.VIEW_EXPECT_PRICE, new ExpectPriceController(christmasService));
            put(Constants.VIEW_BADGE, new BadgeController(christmasService));
        }};
    }

    public static void run() {
        FrontController frontController = new FrontController();
        for (String path : frontController.views) {
            frontController.service(path);
            System.out.println();
        }
    }

    public void service(String path) {
        if (controllers.containsKey(path)) {
            Model model = new Model();
            Controllable controller = controllers.get(path);
            ViewFactory viewFactory = ViewFactory.getInstance();
            Viewable view = viewFactory.getView(path);
            if (view instanceof InputView) {
                view.render(model);
                controller.process(model);
                return;
            }
            String viewPath = controller.process(model);
            ViewModel viewModel = new ViewModel(viewPath, model);
            viewModel.render();
        }
    }
}
