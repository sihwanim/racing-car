package util.validator;

import java.util.Arrays;
import java.util.List;

public class NameValidator extends Validator{
	private static final String DELIMITER = ",";
	private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 존재합니다.";
	private static final String NAME_LENGTH_MESSAGE = "이름은 1자 이상 5자 이하로 입력해야 합니다.";
	private static final String CANNOT_RACE_MESSAGE = "자동차가 2대 미만입니다.";
	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 5;

	// 전체 확인
	public static void validateNames(String input){
		isNull(input);
		isDuplicated(input);
		countCar(input);
	}

	// 이름 하나씩 확인
	public static void validateName(String input){
		isNull(input);
		isRange(input);
	}

	public static void isDuplicated(String input){
		List<String> cars = Arrays.asList(input.split(DELIMITER));
		long cnt = cars.stream().distinct().count();
		if(cars.size() != cnt){
			throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
		}
	}

	public static void countCar(String input){
		List<String> cars = Arrays.asList(input.split(DELIMITER));
		if(cars.size() < 2)
			throw new IllegalArgumentException(CANNOT_RACE_MESSAGE);

	}

	public static void isRange(String input){
		if(input.length() < MIN_LENGTH || input.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_MESSAGE);
		}
	}
}
