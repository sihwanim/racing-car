package racing_car.domain.car;

public class Car {
    private final int NAME_MAX_LENGTH = 5;
    private final int MOVE_STANDARD = 4;
    private final String name;
    private int position;


    public Car(String name) {
        this.name = limitNameLength(name);
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = limitNameLength(name);
        this.position = position;
    }

    // TODO: 자동차 이름 길이 예외처리
    public String limitNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH)
            return name.substring(0, NAME_MAX_LENGTH);
        return name;
    }

    public void go(int number) {
        if (number >= MOVE_STANDARD)
            position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
