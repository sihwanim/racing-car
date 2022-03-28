package util.generator;

import util.validator.TrailNumberValidator;

public class TrialNumberGenerator {

	public static int generateTrialNumber(String input){
		TrailNumberValidator.validate(input);
		return Integer.parseInt(input);
	}

}
