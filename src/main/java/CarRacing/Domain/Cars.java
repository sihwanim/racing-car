package CarRacing.Domain;

import CarRacing.Utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final int CARS_COUNT_MIN = 2;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNumberOfCars(cars);
        validateDuplication(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateNumberOfCars(final List<Car> cars) {
        if (cars.size() < CARS_COUNT_MIN) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    private void validateDuplication(final List<Car> cars) {
        final HashSet<Car> nonDuplicateCars = new HashSet<>(cars);
        if (nonDuplicateCars.size() != cars.size()) {
            throw new IllegalArgumentException("중복되는 이름을 입력할 수 없습니다.");
        }
    }

    public void tryToMove() {
        cars.forEach(car -> {
            final int currentRpm = RandomUtils.nextNumber();
            car.tryToMove(currentRpm);
        });

    }

    public int findPositionMax() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(Integer::max)
                .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다."));
    }

    public List<String> findCarNamesLocatedAt(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
