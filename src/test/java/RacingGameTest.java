import CarRacing.Domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private static Car newCar(String name, int position) {
        final Car car = new Car(new Name(name));
        for (int i = 0; i < position; i++) {
            car.tryToMove(4);
        }
        return car;
    }

    @ParameterizedTest
    @DisplayName("우승자 판별 테스트")
    @MethodSource("provideRacingGameForFindWinner")
    void findWinnerTest(RacingGame racingGame, List<String> expected) {
        final List<String> actual = racingGame.findWinners();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRacingGameForFindWinner() {
        return Stream.of(
                Arguments.of(new RacingGame(provideCars_우승자_한명(), new Trial(1)),
                        Arrays.asList("루트")),
                Arguments
                        .of(new RacingGame(provideCars_우승자_두명(), new Trial(1)),
                                Arrays.asList("루트", "소롱")),
                Arguments.of(new RacingGame(provideCars_모두_움직이지_않음(), new Trial(1)),
                        Arrays.asList("루트", "소롱", "포비"))
        );
    }

    private static Cars provideCars_우승자_한명() {
        List<Car> value = new ArrayList<>();
        value.add(newCar("루트", 5));
        value.add(newCar("소롱", 3));
        value.add(newCar("포비", 1));
        return new Cars(value);
    }

    private static Cars provideCars_우승자_두명() {
        List<Car> value = new ArrayList<>();
        value.add(newCar("루트", 5));
        value.add(newCar("소롱", 5));
        value.add(newCar("포비", 1));
        return new Cars(value);
    }

    private static Cars provideCars_모두_움직이지_않음() {
        List<Car> value = new ArrayList<>();
        value.add(new Car(new Name("루트")));
        value.add(new Car(new Name("소롱")));
        value.add(new Car(new Name("포비")));

        return new Cars(value);
    }
}
