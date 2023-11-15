package christmas.model.badge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @Test
    @DisplayName("20000원 이상 구매시 산타 배지")
    void over20000() {
        Assertions.assertThat(Badge.findByPrice(20000L)).isEqualTo(Badge.SANTA);
    }

    @Test
    @DisplayName("10000원 이상 구매시 트리 배지")
    void over10000() {
        Assertions.assertThat(Badge.findByPrice(10000L)).isEqualTo(Badge.TREE);
    }

    @Test
    @DisplayName("5000원 이상 구매시 별 배지")
    void over5000() {
        Assertions.assertThat(Badge.findByPrice(5000L)).isEqualTo(Badge.STAR);
    }
}