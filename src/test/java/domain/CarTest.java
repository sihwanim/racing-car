package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    @Test
    @DisplayName("자동차를 만들 수 있다.")
    public void makeCar() {
        String name = "군밤";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 숫자가 4이상이면 달린다.")
    public void runCar() {
        Car runningCar = new Car("run");
        Car stopCar = new Car("stop");
        runningCar.run(4);
        stopCar.run(1);
        assertAll(
                () -> assertThat(runningCar.getPosition()).isEqualTo(1),
                () -> assertThat(stopCar.getPosition()).isEqualTo(0)
        );
    }
}
