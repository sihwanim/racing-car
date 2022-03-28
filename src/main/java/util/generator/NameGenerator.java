package util.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.validator.NameValidator;

public class NameGenerator {
	public static final String DELIMITER = ",";

	public static List<String> generatorCarsName(String input){
		NameValidator.validateNames(input);

		List<String> carNames = new ArrayList<String>();
		String[] names = input.split(DELIMITER);
		for(String name : names){
			name = name.trim();
			NameValidator.validateName(name);
			carNames.add(name);
		}

		return carNames;
	}
}
