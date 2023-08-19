package domain;

import java.util.List;

public class Game {
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
        return List.of();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
