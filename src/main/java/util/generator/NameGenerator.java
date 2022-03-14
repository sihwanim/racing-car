package util.generator;

import java.util.Arrays;
import java.util.List;
import util.validator.NameValidator;

public class NameGenerator {
	public static final String DELIMITER = ",";

	public static List<String> generatorCarsName(String input){
		NameValidator.validateNames(input);

		List<String> carNames = Arrays.asList(input.split(DELIMITER, -1));
		for(String name : carNames){
			NameValidator.validateName(name);
		}

		return carNames;
	}
}
