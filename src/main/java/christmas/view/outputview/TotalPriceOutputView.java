package christmas.view.outputview;

import front.model.Model;
import front.view.Viewable;

public class TotalPriceOutputView implements Viewable {
    @Override
    public void render(Model model) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", (Long) model.get("totalPrice"));
    }
}
