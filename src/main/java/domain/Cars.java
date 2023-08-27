package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        Engine engine = new RandomEngine();
        this.cars = Arrays.stream(names)
                .map(name -> new Car(name, engine))
                .collect(Collectors.toList());
    }

    public void race() {
        for (Car car : cars) {
            car.run();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
