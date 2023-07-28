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
}
