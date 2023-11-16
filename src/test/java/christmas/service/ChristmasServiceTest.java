package christmas.service;

import christmas.model.badge.Badge;
import christmas.model.menu.Menu;
import christmas.model.order.Order;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasServiceTest {

    private ChristmasService christmasService;
    private LocalDate date;
    private List<Order> orders;

    @BeforeEach
    void beforeEach() {
        christmasService = new ChristmasService();
        date = LocalDate.of(2023, 12, 25);
        orders = List.of(
                new Order(Menu.BarbecueRib, 2),
                new Order(Menu.RedWine, 1)
        );
    }

    @Test
    @DisplayName("메뉴를 주문하면 할인 전 총주문 금액이 결정된다.")
    void orderMenus() {
        christmasService.orderMenus(orders);
        Assertions.assertThat(christmasService.getTotalPrice()).isEqualTo(168000L);
    }

    @Test
    @DisplayName("혜택을 계산하면 혜택 금액이 결정된다."
            + "해택내역 : 크리스마스:3400, 특별할인:1000, 증정할인:25000 ")
    void calculateBenefit() {
        christmasService.selectPurchaseDate(date);
        christmasService.orderMenus(orders);
        Long benefit = christmasService.calculateBenefitPrice();
        Assertions.assertThat(benefit).isEqualTo(-29400);
    }

    @Test
    @DisplayName("예상 금액을 계산한다.")
    void calculateExpectedPrice() {
        christmasService.selectPurchaseDate(date);
        christmasService.orderMenus(orders);
        Assertions.assertThat(christmasService.calculateExpectedPrice()).isEqualTo(138600);
    }

    @Test
    @DisplayName("증정 여부를 확인한다.")
    void checkPresent() {
        christmasService.selectPurchaseDate(date);
        christmasService.orderMenus(orders);
        Order order = christmasService.checkPresent();
        Assertions.assertThat(order.getMenu()).isEqualTo(Menu.Champagne);
    }

    @Test
    @DisplayName("배지 여부를 확인한다.")
    void checkBadge() {
        christmasService.selectPurchaseDate(date);
        christmasService.orderMenus(orders);
        Badge badge = christmasService.checkBadge();
        Assertions.assertThat(badge).isEqualTo(Badge.SANTA);
    }

}