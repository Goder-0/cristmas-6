package christmas.view.outputview;

import front.model.Model;
import front.view.Viewable;

public class TotalBenefitOutputView implements Viewable {
    @Override
    public void render(Model model) {
        System.out.println("<총혜택 금액>");
        System.out.printf("-%,d원\n", (Long) model.get("totalBenefitPrice"));
    }
}
