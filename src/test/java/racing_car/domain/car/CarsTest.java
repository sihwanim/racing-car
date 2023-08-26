package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        String[] names = {"test1", "test2", "test3"};
        cars = new Cars(names);
    }

    @DisplayName("차가 전진한다.")
    @Test
    void goCar() {
        Car car = cars.getCars().get(0);
        cars.goCar(car, 4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차가 전진하지 않는다.")
    @Test
    void notGoCar() {
        Car car = cars.getCars().get(0);
        cars.goCar(car, 2);
        assertThat(car.getPosition()).isEqualTo(0);
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