package domain;

public class Round {
    private static final int ROUND_RANGE_MIN = 0;
    private int round;

    public Round(String round) {
        try {
            this.round = Integer.parseInt(round);
            validateRound(round);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("레이싱 횟수는 자연수이어야 합니다.");
        }
    }

    private void validateRound(String round) {
        if (Integer.parseInt(round) < ROUND_RANGE_MIN) {
            throw new IllegalArgumentException("레이싱 횟수는 0보다 커야합니다.");
        }
    }

    public void over() {
        this.round--;
    }

    public boolean isEnd() {
        return round == ROUND_RANGE_MIN;
    }

    public int getRound() {
        return round;
    }
}
