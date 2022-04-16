package CarRacing.Domain;

import java.util.Objects;

public class Trial {
    private static final Integer TRIAL_MIN = 1;
    private static final Integer TRIAL_MAX = Integer.MAX_VALUE;

    private final int finalTrialNumber;
    private int currentTrialNumber;

    public Trial(final int finalTrialNumber) {
        validateBound(finalTrialNumber);
        this.finalTrialNumber = finalTrialNumber;
        this.currentTrialNumber = 0;
    }

    private static void validateBound(final int value) {
        if (value < TRIAL_MIN || value > TRIAL_MAX) {
            throw new IllegalArgumentException(
                    String.format("숫자는 %d 이상 %d 이하여야 합니다.",TRIAL_MIN,TRIAL_MAX));
        }
    }

    public void moveToNextTrial() {
        currentTrialNumber++;
    }

    public boolean isFinished() {
        return currentTrialNumber >= finalTrialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trial trial = (Trial) o;
        return finalTrialNumber == trial.finalTrialNumber
                && currentTrialNumber == trial.currentTrialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalTrialNumber, currentTrialNumber);
    }
}
