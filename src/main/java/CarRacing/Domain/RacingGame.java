package CarRacing.Domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final Trial trial;

    public RacingGame(final Cars cars, final Trial trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public void tryToMove() {
        cars.tryToMove();
        trial.moveToNextTrial();
    }

    public List<String> findWinners() {
        final int positionMax = cars.findPositionMax();
        return cars.findCarNamesLocatedAt(positionMax);
    }

    public boolean isFinished() {
        return trial.isFinished();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
