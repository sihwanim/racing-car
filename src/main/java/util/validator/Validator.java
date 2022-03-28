package util.validator;

public class Validator {
	private static final String NULL_MESSAGE = "NULL은 입력할 수 없습니다.";
	private static final String EMPTY_MESSAGE = "빈 문자열은 입력할 수 없습니다.";

	public static void isNull(String input){
		if(input.equals(null)){
			throw new IllegalArgumentException(NULL_MESSAGE);
		}
	}

	public static void isEmpty(String input){
		if(input.isEmpty()){
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}
}
