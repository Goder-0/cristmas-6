package christmas.view.outputview;

import christmas.model.order.Order;
import front.model.Model;
import front.view.Viewable;

public class PresentOutputView implements Viewable {
    @Override
    public void render(Model model) {
        System.out.println("<증정 메뉴>");
        Order present = (Order) model.get("present");
        System.out.println(present.toString());
    }
}
