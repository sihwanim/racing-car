package racing_car.utils;

import java.util.Random;

public class NumberUtil {
    public static int generateRandomNum(int under) {
        if (under <= 0) {
            // TODO: 예외처리
            return 1;
        }
        Random random = new Random();
        return random.nextInt(under);
    }
}
