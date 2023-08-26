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
        car.go(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차가 멈추는 경우")
    @Test
    void not_go() {
        car.go(1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}