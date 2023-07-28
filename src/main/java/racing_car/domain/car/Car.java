package racing_car.domain.car;

public class Car {
    private final String name;
    private int goCount;


    public Car(String name) {
        this.name = name;
        this.goCount = 0;
    }

    public Car(String name, int goCount) {
        this.name = name;
        this.goCount = goCount;
    }

    public String getName() {
        return name;
    }

    public int getGoCount() {
        return goCount;
    }

    public void go() {
        goCount++;
    }
}
