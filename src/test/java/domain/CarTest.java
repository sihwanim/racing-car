package domain;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static domain.Car.CAR_NAME_VALIDATION_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차를 만들 수 있다.")
    public void makeCar() {
        String name = "ahn";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하여야 한다.")
    public void makeCarWithWrongName() {
        String name = "wrongName";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_VALIDATION_ERROR_MESSAGE);

    }

    @ParameterizedTest
    @CsvSource({"4,1", "5,1", "3,0"})
    @DisplayName("자동차는 숫자가 4이상이면 달린다.")
    public void runCar(int number, int position) {
        Car car = new Car("ahn");
        car.run(number);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
