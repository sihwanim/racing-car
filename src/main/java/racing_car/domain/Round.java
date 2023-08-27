package racing_car.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class Round {
    public static final String ROUND_COUNT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양의 정수만 입력 가능합니다.";
    private int count;

    public Round(String count) {
        try {
            this.count =  Integer.parseInt(count);
            checkPositiveInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_COUNT_ERROR_MESSAGE);
        }
    }

    public void checkPositiveInt() {
        if (count <= 0)
            throw new IllegalArgumentException(ROUND_COUNT_ERROR_MESSAGE);
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round round = (Round) o;
        return count == round.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
