package domain;

public class TrialNumber {

	private int trialNumber;
	private static final String WRONG_TYPE_ERROR_MESSAGE = "시도 횟수는 정수만 입력할 수 있습니다.";
	private static final String OUT_OF_RANGE_ERROR_MESSAGE = "범위 내의 횟수가 아닙니다. (1 ~ 1000)";
	private static final int MIN_RANGE = 1;
	private static final int MAX_RANGE = 1000;

	public TrialNumber(String input) {
		int trialNumber = validateInteger(input);
		validateRange(trialNumber);
		this.trialNumber = trialNumber;
	}

	public int validateInteger(String input) {
		try {
			int trialNumber = Integer.parseInt(input);
			return trialNumber;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(WRONG_TYPE_ERROR_MESSAGE);
		}
	}

	public static void validateRange(int input) {
		if (input < MIN_RANGE || input > MAX_RANGE) {
			throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
		}
	}

	public int getTrialNumber() {
		return trialNumber;
	}

}
