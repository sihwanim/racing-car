package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차들을 생성한다.")
    void create() {
        String[] names = {"a", "b", "c"};
        Cars cars = new Cars(names);
        assertThat(cars.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList()))
                .isEqualTo(List.of(names));
    }

    @Test
    @DisplayName("자동차 경주를 진행할 수 있다.")
    void race() {
        String[] names = {"a", "b", "c"};
        Cars cars = new Cars(names);
        cars.race();
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition())
                    .isGreaterThanOrEqualTo(0)
                    .isLessThanOrEqualTo(1);
        }
    }
}