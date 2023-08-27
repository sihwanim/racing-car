package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차를 만들 수 있다.")
    public void makeCar() {
        String name = "군밤";
        Engine engine = new SteadyEngine();
        Car car = new Car(name, engine);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 조건을 만족하면 달릴 수 있다.")
    public void runCar() {
        Engine engine = new SteadyEngine();
        Car car = new Car("run", engine);
        assertThat(car.getPosition()).isEqualTo(0);
        car.run();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
