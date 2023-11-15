package christmas.model.menu;

import christmas.exception.MenuException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    @DisplayName("이름으로 메뉴를 찾는다.")
    void findMenu() {
        Menu menu = Menu.findByName("양송이수프");
        Assertions.assertThat(menu).isEqualTo(Menu.Mushroom);
    }

    @Test
    @DisplayName("이름으로 메뉴를 못찾으면 예외이다.")
    void findMenuException() {
        Assertions.assertThatThrownBy(() -> Menu.findByName("양송이")).isInstanceOf(MenuException.class);
    }
}