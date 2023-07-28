package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");
        cars = new Cars(new ArrayList<>(Arrays.asList(car1, car2, car3)));
    }

    @DisplayName("차가 전진한다.")
    @Test
    void goCar() {
        Car car = cars.getCars().get(0);
        cars.goCar(car, 6);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차가 전진하지 않는다.")
    @Test
    void notGoCar() {
        Car car = cars.getCars().get(0);
        cars.goCar(car, 2);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}