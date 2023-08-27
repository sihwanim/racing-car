package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static racing_car.domain.car.Name.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racing_car.view.OutputView.CHANGE_ARROW;
import static racing_car.view.OutputView.NAME_CHANGE_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;


    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @DisplayName("이름으로 자동차를 생성한다.")
    @Test
    void createCar() {
        String name = "abc";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("5자 이상의 이름으로 자동차를 생성한다.")
    @Test
    void createCarWithLongName() {
        String name = "abcdefg";
        String result = "abcde";
        String message = CAR_NAME_LENGTH_ERROR_MESSAGE + System.lineSeparator()
            + NAME_CHANGE_MESSAGE + name + CHANGE_ARROW + result + System.lineSeparator();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Car car = new Car(name);
        assertSoftly(softly -> {
            softly.assertThat(car.getName()).isEqualTo(result);
            softly.assertThat(out.toString()).isEqualTo(message);
        });
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