package CarRacing.Utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();
    private static final int RANDOMBOUND = 10;
    private RandomUtils() {
    }

    public static int nextNumber() {
        return RANDOM.nextInt(RANDOMBOUND);
    }
}
