package CarRacing.Domain;

public class Car {

    private final Name name;
    public Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }


    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }
}
