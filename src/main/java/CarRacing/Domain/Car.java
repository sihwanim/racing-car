package CarRacing.Domain;

import java.util.Objects;

public class Car {

    public Name name;

    public Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }
}
