package christmas.view.outputview;

import front.model.Model;
import front.view.Viewable;

public class BadgeOutputView implements Viewable {
    @Override
    public void render(Model model) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println((String) model.get("badge"));
    }
}
