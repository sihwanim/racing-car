package racing_car.domain.car;

import static racing_car.utils.NumberUtil.generateRandomNum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    // TODO: 중복된 이름이 있으면 예외처리
    public Cars(String[] names) {
        this.cars = Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void goCars() {
        cars.forEach(car -> goCar(car, generateRandomNum()));
    }

    public void goCar(Car car, int number) {
        car.go(number);
    }

    public int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition)
            .max().orElseThrow(); // TODO : cars가 비어있을 경우 예외처리
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinners() {
        return cars.stream()
            .filter(car -> car.getPosition() == findMaxPosition())
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
