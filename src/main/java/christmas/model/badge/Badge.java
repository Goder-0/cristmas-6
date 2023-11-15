package christmas.model.badge;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000L),
    TREE("트리", 10000L),
    STAR("별", 5000L),
    EMPTY("", 0L);

    private final String name;
    private final Long price;

    Badge(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public static Badge findByPrice(Long price) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.price <= price)
                .reduce((a, b) -> a.price > b.price ? a : b)
                .orElse(EMPTY);
    }

    public String toString() {
        return name;
    }

}
