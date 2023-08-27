package domain;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;
    private final Engine engine;

    public Car(String name, Engine engine) {
        this.name = new Name(name);
        this.position = new Position(0);
        this.engine = engine;
    }

    public void run() {
        if (engine.canMove()) {
            position.moveForward();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
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
