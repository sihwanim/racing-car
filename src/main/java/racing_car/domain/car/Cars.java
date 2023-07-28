package racing_car.domain.car;

import static racing_car.utils.NumberUtil.generateRandomNum;

import java.util.ArrayList;
import java.util.List;

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
}
