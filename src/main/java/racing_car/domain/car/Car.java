package racing_car.domain.car;

public class Car {
    private final int MOVE_STANDARD = 4;
    private final String name;
    private int position;


    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go(boolean canGo) {
        if (canGo)
            position++;
    }

    public boolean isGo(int standard) {
        return standard >= MOVE_STANDARD;
    }
}
