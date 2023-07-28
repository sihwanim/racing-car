package racing_car.domain.car;

import static racing_car.utils.NumberUtil.generateRandomNum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final int RANDOM_UNDER = 10;
    private final List<Car> cars;


    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
    public void goCars() {
        cars.forEach(car -> goCar(car, generateRandomNum(RANDOM_UNDER)));
    }

    public void goCar(Car car, int num) {
        car.go(car.isGo(num));
    }

    public int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition)
            .max().orElseThrow(); // TODO : cars가 비어있을 경우 예외처리
    }

    public List<String> findWinners() {
        return cars.stream()
            .filter(car -> car.getPosition() == findMaxPosition())
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
