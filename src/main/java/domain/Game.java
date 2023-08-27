package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static final String INVALID_WINNER_ERROR = "우승자를 찾을 수 없습니다.";
    private final Cars cars;
    private final Round round;

    public Game(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        cars.race();
        round.over();
    }

    public boolean isEnd() {
        return round.isEnd();
    }

    public List<Car> findWinners() {
        int winnerPosition = cars.getCars()
                .stream().mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_WINNER_ERROR));

        return cars.getCars()
                .stream().filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
