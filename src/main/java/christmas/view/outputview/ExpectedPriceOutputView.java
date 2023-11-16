package christmas.view.outputview;

import front.model.Model;
import front.view.Viewable;

public class ExpectedPriceOutputView implements Viewable {
    @Override
    public void render(Model model) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", (Long) model.get("expectPrice"));
    }
}
