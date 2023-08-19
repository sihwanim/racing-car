package domain;

import java.util.Objects;

public class Car {
    public static final String CAR_NAME_VALIDATION_ERROR_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";

    private final String name;

    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_VALIDATION_ERROR_MESSAGE);
        }
    }

    public void run(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
