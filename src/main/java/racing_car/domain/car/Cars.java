package racing_car.domain.car;

import static racing_car.utils.NumberUtil.generateRandomNum;
import static racing_car.view.OutputView.printError;
import static racing_car.view.OutputView.printNameChange;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    public static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복된 이름을 사용할 수 없습니다.";
    private List<Car> cars;

    public Cars(String[] names) {
        List<Car> list = Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());

        try {
            this.cars = validateCars(list);
        } catch (IllegalArgumentException e) {
            printError(e);
            this.cars = distinctCars(list);
        }
    }

    public List<Car> validateCars(List<Car> list) {
        List<String> result = list.stream()
            .map(Car::getName)
            .distinct()
            .collect(Collectors.toList());

        if (list.size() != result.size()) {
            throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR_MESSAGE);
        }

        return list;
    }

    public List<Car> distinctCars(List<Car> list) {
        Map<String, Long> duplications = list.stream()
            .collect(Collectors.groupingBy(Car::getName, Collectors.counting()));

        for (String name : duplications.keySet()) {
            if (duplications.get(name) == 1)
                continue;
            editCarNames(name, list, duplications.get(name));
        }
        return list;
    }

    public void editCarNames(String name, List<Car> cars, long limit) {
        int index = 1;

        for (Car car : cars) {
            if (car.getName().equals(name)) {
                car.setName(car.getName() + "(" + index + ")");
                printNameChange(name, car.getName());
                if (index++ == limit)
                    break;
            }
        }
    }


    public void goCars() {
        cars.forEach(car -> goCar(car, generateRandomNum()));
    }

    public void goCar(Car car, int number) {
        car.go(number);
    }

    public int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition)
            .max().orElse(-1);
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
