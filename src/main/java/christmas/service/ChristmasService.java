package christmas.service;

import christmas.model.badge.Badge;
import christmas.model.benefit.Benefit;
import christmas.model.benefit.ChristmasDiscount;
import christmas.model.benefit.Present;
import christmas.model.benefit.SpecialDiscount;
import christmas.model.benefit.WeekdayDiscount;
import christmas.model.benefit.WeekendDiscount;
import christmas.model.menu.Menu;
import christmas.model.order.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChristmasService {
    private final List<Benefit> benefits = new ArrayList<>();
    private final List<Order> orders;
    private LocalDate date;
    private long totalPrice = 0;
    private long totalBenefitPrice = 0;
    private Order present = new Order(Menu.Empty, 1);

    public ChristmasService() {
        orders = new ArrayList<>();
        benefits.addAll(List.of(
                new WeekdayDiscount(),
                new Present(),
                new SpecialDiscount(),
                new WeekendDiscount(),
                new ChristmasDiscount()
        ));
    }

    public void selectPurchaseDate(LocalDate date) {
        this.date = date;
    }

    public void orderMenus(List<Order> orders) {
        this.orders.addAll(orders);
        totalPrice = 0L;
        for (Order order : this.orders) {
            totalPrice += order.getPrice();
        }
    }

    private boolean isPresentable(Benefit benefit) {
        return benefit instanceof Present;
    }

    private void removeBenefits() {
        benefits.removeIf(benefit -> !benefit.isAble(date, orders));
    }

    public Long calculateBenefitPrice() {
        removeBenefits();
        totalBenefitPrice = 0L;
        for (Benefit benefit : benefits) {
            benefit.update(date, orders);
            totalBenefitPrice += benefit.getAmount();
        }
        return -totalBenefitPrice;
    }

    public List<Benefit> getBenefits() {
        calculateBenefitPrice();
        return benefits;
    }

    public Long calculateExpectedPrice() {
        calculateBenefitPrice();
        return totalPrice + present.getPrice() - totalBenefitPrice;
    }

    public Badge checkBadge() {
        return Badge.findByPrice(totalPrice);
    }

    public Order checkPresent() {
        removeBenefits();
        Optional<Benefit> champagnePresent = benefits.stream()
                .filter(this::isPresentable)
                .findAny();
        champagnePresent.ifPresent(benefit -> present = ((Present) benefit).getOrder());
        return present;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
