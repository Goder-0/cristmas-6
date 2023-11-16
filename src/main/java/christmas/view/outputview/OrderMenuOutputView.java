package christmas.view.outputview;

import christmas.model.order.Order;
import front.model.Model;
import front.view.Viewable;
import java.util.List;

public class OrderMenuOutputView implements Viewable {

    @Override
    public void render(Model model) {
        System.out.println("<주문 메뉴>");
        List<Order> orders = (List<Order>) model.get("orders");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }
}
