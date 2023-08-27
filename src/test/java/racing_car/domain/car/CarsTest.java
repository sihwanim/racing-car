package racing_car.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static racing_car.domain.car.Cars.CAR_NAMES_DUPLICATE_ERROR_MESSAGE;
import static racing_car.domain.car.Name.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racing_car.view.OutputView.CHANGE_ARROW;
import static racing_car.view.OutputView.NAME_CHANGE_MESSAGE;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

    @DisplayName("중복된 이름을 가진 차들을 생성한다.")
    @Test
    void createCarsWithDuplicates() {
        String[] names = {"test1", "test1", "test2"};
        String[] duplications = {"test1(1)", "test1(2)"};
        String message = CAR_NAMES_DUPLICATE_ERROR_MESSAGE + System.lineSeparator()
            + NAME_CHANGE_MESSAGE + names[0] + CHANGE_ARROW + duplications[0] + System.lineSeparator()
            + NAME_CHANGE_MESSAGE + names[0] + CHANGE_ARROW + duplications[1] + System.lineSeparator();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        cars = new Cars(names);

        assertSoftly(softly -> {
            softly.assertThat(cars.getCars().get(0).getName()).isEqualTo(duplications[0]);
            softly.assertThat(cars.getCars().get(1).getName()).isEqualTo(duplications[1]);
            softly.assertThat(out.toString()).isEqualTo(message);
        });
    }

    @DisplayName("앞의 5자가 중복된 이름을 가진 차들을 생성한다.")
    @Test
    void createCarsWithSomeMatchingNames() {
        String[] names = {"test1", "test10", "test2"};
        String[] duplications = {"test1(1)", "test1(2)"};
        String message = CAR_NAME_LENGTH_ERROR_MESSAGE + System.lineSeparator()
            + NAME_CHANGE_MESSAGE + names[1] + CHANGE_ARROW + names[0] + System.lineSeparator()
            + CAR_NAMES_DUPLICATE_ERROR_MESSAGE + System.lineSeparator()
            + NAME_CHANGE_MESSAGE + names[0] + CHANGE_ARROW + duplications[0] + System.lineSeparator()
            + NAME_CHANGE_MESSAGE + names[0] + CHANGE_ARROW + duplications[1] + System.lineSeparator();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        cars = new Cars(names);

        assertSoftly(softly -> {
            softly.assertThat(cars.getCars().get(0).getName()).isEqualTo(duplications[0]);
            softly.assertThat(cars.getCars().get(1).getName()).isEqualTo(duplications[1]);
            softly.assertThat(out.toString()).isEqualTo(message);
        });
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