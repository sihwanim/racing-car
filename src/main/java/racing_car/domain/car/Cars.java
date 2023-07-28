package racing_car.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;


    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
    public void goCars() {
        cars.forEach(car -> goCar(car, 8)); // 랜덤값으로 수정
    }

    public void goCar(Car car, int num) {
        car.go(car.isGo(num));
    }
}
