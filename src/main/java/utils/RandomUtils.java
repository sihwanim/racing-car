package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();
    public static final String RANGE_FORMAT_ERROR = "범위의 시작은 끝보다 작아야 합니다";
    public static final String RANGE_MIN_LIMIT_ERROR = "범위의 시작은 0보다 커야 합니다";

    private RandomUtils() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException(RANGE_FORMAT_ERROR);
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException(RANGE_MIN_LIMIT_ERROR);
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }
}
