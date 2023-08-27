package racing_car.domain.car;

import static racing_car.domain.car.Name.NAME_MAX_LENGTH;
import static racing_car.view.OutputView.printError;
import static racing_car.view.OutputView.printNameChange;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private Name name;
    private int position;


    public Car(String name) {
        try {
            this.name = new Name(name);
            this.position = 0;
        }catch (IllegalArgumentException e) {
            printError(e);
            this.name = new Name(name.substring(0, NAME_MAX_LENGTH));
            printNameChange(name, getName());
        }
    }

    public Car(String name, int position) {
        try {
            this.name = new Name(name);
            this.position = position;
        }catch (IllegalArgumentException e) {
            printError(e);
            this.name = new Name(name.substring(0, NAME_MAX_LENGTH));
            printNameChange(name, getName());
        }
    }

    public void go(int number) {
        if (number >= MOVE_STANDARD)
            position++;
    }

    public String getName() {
        return name.getName();
    }

    public void setName(String name) {
        this.name.setName(name);
    }

    public int getPosition() {
        return position;
    }
}
