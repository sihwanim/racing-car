package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;


    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @DisplayName("차가 전진하는 경우")
    @Test
    void go() {
        car.go(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차가 멈추는 경우")
    @Test
    void not_go() {
        car.go(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("전진조건을 통과한 경우")
    @Test
    void isGo_true() {
        boolean result = car.isGo(4);
        assertThat(result).isTrue();
    }

    @DisplayName("전진조건을 통과하지 못한 경우")
    @Test
    void isGo_false() {
        boolean result = car.isGo(3);
        assertThat(result).isFalse();
    }
}