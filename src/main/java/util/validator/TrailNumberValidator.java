package util.validator;

public class TrailNumberValidator extends Validator {
	private static final int MIN_TRIAL = 1;
	private static final String NOT_POSITIVE_NUMBER_MESSAGE = "시도 횟수는 1번 이상이어야 합니다.";
	private static final String NOT_INTEGER_MESSAGE = "시도 횟수는 양의 정수만 입력 가능합니다.";

	public static void validate(String input){
		isNull(input);
		isEmpty(input);
		isInteger(input);
		isPositiveNumber(input);
	}

	public static void isInteger(String input){
		try{
			Integer.parseInt(input);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
		}
	}

	public static void isPositiveNumber(String input){
		if(Integer.parseInt(input) < MIN_TRIAL){
			throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_MESSAGE);
		}
	}

}
