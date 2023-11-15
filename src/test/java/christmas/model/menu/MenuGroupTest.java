package christmas.model.menu;

import christmas.model.order.Order;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MenuGroupTest {

    @Test
    @DisplayName("주문내역으로 메뉴 항목을 얻을 수 있다.")
    void findGroupsByOrders() {
        List<Order> orders = List.of(
                new Order(Menu.ChocolateCake, 1),
                new Order(Menu.BarbecueRib, 1)
        );
        List<MenuGroup> groupsByOrders = MenuGroup.findGroupsByOrders(orders);
        Assertions.assertThat(groupsByOrders)
                .contains(MenuGroup.Dessert)
                .contains(MenuGroup.MainDish);
    }

    @DisplayName("에피타이저 테스트")
    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"Mushroom", "Tapas", "CaesarSalad"})
    void findByMenuGroup_appetizer(Menu menu) {
        MenuGroup menuGroup = MenuGroup.findByMenuGroup(menu);
        Assertions.assertThat(menuGroup).isEqualTo(MenuGroup.Appetizer);
    }

    @DisplayName("메인 테스트")
    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"TBoneSteak", "BarbecueRib", "SeafoodPasta", "ChristmasPasta"})
    void findByMenuGroup_main(Menu menu) {
        MenuGroup menuGroup = MenuGroup.findByMenuGroup(menu);
        Assertions.assertThat(menuGroup).isEqualTo(MenuGroup.MainDish);
    }

    @DisplayName("디저트 테스트")
    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"ChocolateCake", "IceCream"})
    void findByMenuGroup_dessert(Menu menu) {
        MenuGroup menuGroup = MenuGroup.findByMenuGroup(menu);
        Assertions.assertThat(menuGroup).isEqualTo(MenuGroup.Dessert);
    }

    @DisplayName("음료 테스트")
    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"ZeroCoke", "RedWine", "Champagne"})
    void findByMenuGroup_drink(Menu menu) {
        MenuGroup menuGroup = MenuGroup.findByMenuGroup(menu);
        Assertions.assertThat(menuGroup).isEqualTo(MenuGroup.Drink);
    }
}