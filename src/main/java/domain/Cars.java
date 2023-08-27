package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void race() {
        Random random = new Random();
        for (Car car : cars) {
            car.run(random.nextInt(9));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
