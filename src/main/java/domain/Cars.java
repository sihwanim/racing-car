package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;
	private static final String SPLIT_POINT = ",";
	private static final int MINIMUM_COUNT = 0;
	private static final String MINIMUM_COUNT_ERROR_MESSAGE = "차량이 한대 이상이어야 합니다.";
	private static final String DUPLICATE_NAME_ERROR_MESSAGE = "이름이 중복된 차량이 있습니다.";

	public Cars(String carNames) {
		this.cars = splitNames(carNames);
		for (Car car : cars) {
			System.out.println(car.getName());
		}
		System.out.println(cars.toString());
	}

	public static List<Car> splitNames(String carNames) {
		List<String> carNameList = Arrays.stream(carNames.split(SPLIT_POINT))
			.collect(Collectors.toList());

		validateCountOfCars(carNameList);
		validateDuplication(carNameList);

		List<Car> carList = new ArrayList();
//		List<Car> cars = carNameList.stream()
//			.map(Car::new)
//			.collect(Collectors.toList());
		for (String name : carNameList) {
			Car car = new Car(name);
			carList.add(car);
		}

		carList.forEach(car -> System.out.println(car.getName()));

		return carList;
	}

	public void goForwardRandomly() {
		for (Car car : cars) {
			car.goForward();
		}
	}

	public List<String> getWinners() {
		final int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private static void validateCountOfCars(List<String> carList) {
		if (carList.size() == MINIMUM_COUNT) {
			throw new IllegalArgumentException(MINIMUM_COUNT_ERROR_MESSAGE);
		}
	}

	private static void validateDuplication(List<String> carList) {
		HashSet set = new HashSet(carList);
		if (set.size() != carList.size()) {
			throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
		}
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	public List<Car> getCars() {
		return cars;
	}
}
