package util;

import java.util.Random;

public class RandomUtil {

	private static final int MAX_RANGE = 9;
	private static final int MIN_RANGE = 0;

	public int createRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(MAX_RANGE - MIN_RANGE) + MIN_RANGE;

		return randomNumber;

	}

}
