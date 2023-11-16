package christmas.model.menu;

import christmas.exception.MenuException;
import java.util.Arrays;

public enum Menu {
    Empty("없음", 0L),
    Mushroom("양송이수프", 6000L),
    Tapas("타파스", 5500L),
    CaesarSalad("시저샐러드", 8000L),
    TBoneSteak("티본스테이크", 55000L),
    BarbecueRib("바비큐립", 54000L),
    SeafoodPasta("해산물파스타", 35000L),
    ChristmasPasta("크리스마스파스타", 25000L),
    ChocolateCake("초코케이크", 15000L),
    IceCream("아이스크림", 5000L),
    ZeroCoke("제로콜라", 3000L),
    RedWine("레드와인", 60000L),
    Champagne("샴페인", 25000L);
    private final String name;
    private final Long price;

    Menu(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public static Menu findByName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findAny()
                .orElseThrow(MenuException::new);
    }

    public Long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
