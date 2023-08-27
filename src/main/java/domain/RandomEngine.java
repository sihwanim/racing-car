package domain;

import utils.RandomUtils;

public class RandomEngine implements Engine {
    public static final int RUNNING_LIMIT = 4;
    public static final int MAX_RUNNING_RATE = 9;
    public static final int MIN_RUNNING_RATE = 0;

    @Override
    public boolean canMove() {
        return RandomUtils.nextInt(MIN_RUNNING_RATE, MAX_RUNNING_RATE) >= RUNNING_LIMIT;
    }
}
