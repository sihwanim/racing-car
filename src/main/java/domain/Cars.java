package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import util.RandomUtil;

public class Cars {
	private final List<Car> cars;
	private static final String SPLIT_POINT = ",";
	private static final int MINIMUM_COUNT = 0;
	private static final String MINIMUM_COUNT_ERROR_MESSAGE = "차량이 한대 이상이어야 합니다.";
	private static final String DUPLICATE_NAME_ERROR_MESSAGE = "이름이 중복된 차량이 있습니다.";

	public Cars(String carNames) {
		this.cars = splitNames(carNames);
	}

	public List<Car> splitNames(String carNames) {
		List<String> carNameList = Arrays.stream(carNames.split(SPLIT_POINT))
			.collect(Collectors.toList());

		validateCountOfCars(carNameList);
		validateDuplication(carNameList);

		List<Car> cars = carNameList.stream()
			.map(Car::new)
			.collect(Collectors.toList());

		return cars;
	}

	public void goForwardRandomly() {
		RandomUtil randomUtil = new RandomUtil();

		for (Car car : cars) {
			int randomNumber = randomUtil.createRandomNumber();
			car.goForward(randomNumber);
		}
	}

	public List<String> getWinners() {
		final int maxPosition = getMaxPosition();
		List<String> winners = cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());

		return winners;
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
