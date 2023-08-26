package racing_car.utils;

import java.util.Random;

public class NumberUtil {
    private static final int RANDOM_UNDER = 10;

    public static int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_UNDER);
    }
}
