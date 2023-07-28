package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static racing_car.utils.NumberUtil.generateRandomNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @DisplayName("0 ~ 9 사이 숫자를 생성한다.")
    @Test
    void generateNum() {
        int num1 = generateRandomNum(10);
        int num2 = generateRandomNum(10);
        int num3 = generateRandomNum(10);

        assertSoftly(softly -> {
            softly.assertThat(num1).isGreaterThanOrEqualTo(0).isLessThan(10);
            softly.assertThat(num2).isGreaterThanOrEqualTo(0).isLessThan(10);
            softly.assertThat(num3).isGreaterThanOrEqualTo(0).isLessThan(10);
        });
    }

    @DisplayName("우승자를 찾아낸다.")
    @Test
    void findWinner() {
        String name = "winner";
        int position = 3;
        cars.getCars().add(new Car(name, position));

        String winner = cars.findWinners().get(0);

        assertThat(winner).isEqualTo(name);
    }

    @DisplayName("우승자들을 찾아낸다.")
    @Test
    void findWinners() {
        String name1 = "winner1";
        String name2 = "winner2";
        int position = 3;
        cars.getCars().add(new Car(name1, position));
        cars.getCars().add(new Car(name2, position));

        List<String> winners = cars.findWinners();

        assertSoftly(softly -> {
            softly.assertThat(winners.get(0)).isEqualTo(name1);
            softly.assertThat(winners.get(1)).isEqualTo(name2);
        });
    }
}