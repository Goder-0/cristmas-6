package front.view;

import christmas.Constants;
import christmas.view.inputview.DateInputView;
import christmas.view.inputview.OrderInputView;
import christmas.view.outputview.BadgeOutputView;
import christmas.view.outputview.BenefitDetailOutputView;
import christmas.view.outputview.ExpectedPriceOutputView;
import christmas.view.outputview.OrderMenuOutputView;
import christmas.view.outputview.PresentOutputView;
import christmas.view.outputview.TotalBenefitOutputView;
import christmas.view.outputview.TotalPriceOutputView;
import java.util.HashMap;

public class ViewFactory {

    private static ViewFactory viewFactory;
    private final HashMap<String, Viewable> views;

    public ViewFactory() {
        views = new HashMap<>();
        views.put(Constants.VIEW_DATE, new DateInputView());
        views.put(Constants.VIEW_ORDER, new OrderInputView());
        views.put(Constants.VIEW_BENEFIT_DETAIL, new BenefitDetailOutputView());
        views.put(Constants.VIEW_EXPECT_PRICE, new ExpectedPriceOutputView());
        views.put(Constants.VIEW_ORDER_DETAIL, new OrderMenuOutputView());
        views.put(Constants.VIEW_PRESENT, new PresentOutputView());
        views.put(Constants.VIEW_TOTAL_BENEFIT, new TotalBenefitOutputView());
        views.put(Constants.VIEW_TOTAL_PRICE, new TotalPriceOutputView());
        views.put(Constants.VIEW_BADGE, new BadgeOutputView());
    }

    public static ViewFactory getInstance() {
        if (viewFactory == null) {
            viewFactory = new ViewFactory();
            return viewFactory;
        }
        return viewFactory;
    }

    public boolean hasView(String viewPath) {
        return views.containsKey(viewPath);
    }

    public Viewable getView(String viewPath) {
        return views.get(viewPath);
    }
}
