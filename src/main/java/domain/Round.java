package domain;

public class Round {
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
        if (Integer.parseInt(round) < 0) {
            throw new IllegalArgumentException("레이싱 횟수는 0보다 커야합니다.");
        }
    }

    public void over() {
        round--;
    }

    public boolean isEnd() {
        return round == 0;
    }

    public int getRound() {
        return round;
    }
}
