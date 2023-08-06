package domain;

public class Name {

	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 5;
	private static final String LENGTH_ERROR_MESSAGE = "은(는) 이름 길이 범위에 맞지 않습니다.";
	private String name;

	public String getName() {
		return name;
	}

	public Name(String name) {
		validator(name);
		this.name = name;
	}

	public static void validator(String name) {
		int length = name.length();
		if (length < MIN_LENGTH || length > MAX_LENGTH) {
			throw new IllegalArgumentException(name + LENGTH_ERROR_MESSAGE);
		}
	}

}
