package CarRacing.Utils;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();
    private static final int RANDOM_NUMBER = 10;


    public int goRandomNumber() {
        return random.nextInt(RANDOM_NUMBER);
    }
}
