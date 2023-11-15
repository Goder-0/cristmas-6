package christmas.model.menu;

import christmas.exception.MenuException;
import christmas.model.order.Order;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MenuGroup {
    Empty(List.of()),
    Appetizer(List.of(Menu.Mushroom, Menu.Tapas, Menu.CaesarSalad)),
    MainDish(List.of(Menu.TBoneSteak, Menu.BarbecueRib, Menu.SeafoodPasta, Menu.ChristmasPasta)),
    Dessert(List.of(Menu.ChocolateCake, Menu.IceCream)),
    Drink(List.of(Menu.ZeroCoke, Menu.RedWine, Menu.Champagne));

    private final List<Menu> menus;

    MenuGroup(List<Menu> menus) {
        this.menus = menus;
    }

    public static List<MenuGroup> findGroupsByOrders(List<Order> orders) {
        return orders.stream()
                .map(order -> findByMenuGroup(order.getMenu()))
                .toList();
    }

    public static MenuGroup findByMenuGroup(Menu menu) {
        return Arrays.stream(MenuGroup.values())
                .filter(menuGroup -> menuGroup.hasMenu(menu))
                .findAny()
                .orElseThrow(MenuException::new);
    }

    public Boolean hasMenu(Menu menu) {
        return menus.stream()
                .anyMatch(m -> m.equals(menu));
    }
}
