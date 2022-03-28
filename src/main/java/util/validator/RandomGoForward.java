package util.validator;

import java.util.Random;

public class RandomGoForward {
	private static final Random random;
	private static final int GO_FORWARD_NUMBER = 4;
	private static final int RANGE_NUMBER = 10;

	static {
		random = new Random();
		random.setSeed(System.currentTimeMillis());
	}

	public static boolean goFoward(){
		if(random.nextInt(RANGE_NUMBER) >= 4)
			return true;
		return false;
	}
}
