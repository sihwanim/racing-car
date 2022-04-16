package CarRacing.Domain;

import java.util.Objects;

public class Car {
    private static final int MOVABLE_RPM_MIN = 4;

    private final Name name;

    private Position position = Position.valueOf(0);

    public Car(final Name name) {
        this.name = new Name(name);
    }

    public void tryToMove(final int currentRPM) {
        if (currentRPM >= MOVABLE_RPM_MIN) {
            move();
        }
    }

    private void move() {
        position = position.next();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
