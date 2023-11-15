package christmas.model.benefit;

import christmas.model.menu.Menu;
import christmas.model.order.Order;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {

    private LocalDate date;
    private List<Order> orders;

    @Test
    @DisplayName("크리스마스 할인 테스트")
    void christmasDiscountTest() {
        ChristmasDiscount discount = new ChristmasDiscount();
        date = LocalDate.of(2023, 12, 25);
        orders = List.of(
                new Order(Menu.BarbecueRib, 1)
        );
        discount.update(date, orders);
        Assertions.assertThat(discount.isAble(date, orders)).isTrue();
        Assertions.assertThat(discount.getAmount()).isEqualTo(3400);
    }

    @Test
    @DisplayName("증정 테스트")
    void presentTest() {
        Present discount = new Present();
        date = LocalDate.of(2023, 12, 25);
        orders = List.of(
                new Order(Menu.BarbecueRib, 3)
        );
        discount.update(date, orders);
        Assertions.assertThat(discount.isAble(date, orders)).isTrue();
        Assertions.assertThat(discount.getAmount()).isEqualTo(25000);
    }

    @Test
    @DisplayName("평일 할인 테스트")
    void weekdayDiscountTest() {
        WeekdayDiscount discount = new WeekdayDiscount();
        date = LocalDate.of(2023, 12, 25);
        orders = List.of(
                new Order(Menu.ChocolateCake, 1)
        );
        discount.update(date, orders);
        Assertions.assertThat(discount.isAble(date, orders)).isTrue();
        Assertions.assertThat(discount.getAmount()).isEqualTo(2023);
    }

    @Test
    @DisplayName("주말 할인 테스트")
    void weekendDiscountTest() {
        WeekendDiscount discount = new WeekendDiscount();
        date = LocalDate.of(2023, 12, 24);
        orders = List.of(
                new Order(Menu.BarbecueRib, 1)
        );
        discount.update(date, orders);
        Assertions.assertThat(discount.isAble(date, orders)).isTrue();
        Assertions.assertThat(discount.getAmount()).isEqualTo(2023);
    }

    @Test
    @DisplayName("특별 할인 테스트")
    void specialDiscountTest() {
        SpecialDiscount discount = new SpecialDiscount();
        date = LocalDate.of(2023, 12, 25);
        orders = List.of(
                new Order(Menu.BarbecueRib, 1)
        );
        discount.update(date, orders);
        Assertions.assertThat(discount.isAble(date, orders)).isTrue();
        Assertions.assertThat(discount.getAmount()).isEqualTo(1000);
    }

}