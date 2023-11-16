package christmas.view.outputview;

import christmas.model.benefit.Benefit;
import front.model.Model;
import front.view.Viewable;
import java.util.List;

public class BenefitDetailOutputView implements Viewable {
    @Override
    public void render(Model model) {
        System.out.println("<혜택 내역>");
        List<Benefit> benefitDetails = (List<Benefit>) model.get("benefits");
        for (Benefit benefitDetail : benefitDetails) {
            System.out.println(benefitDetail.toString());
        }
        if (benefitDetails.isEmpty()) {
            System.out.println("없음");
        }
    }
}
