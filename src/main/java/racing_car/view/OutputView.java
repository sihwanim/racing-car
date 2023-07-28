package racing_car.view;

import java.util.List;
import racing_car.domain.car.Car;

public class OutputView {
    private static final String RESULT = "실행 결과";
    private static final String CAR_POSITION_SEPARATOR = " : ";
    private static final String MOVE_DISTANCE_UNIT = "-";


    public void printResultMessage() {
        System.out.println(RESULT);
    }

    public void printCarPosition(List<Car> cars) {
        cars.forEach(car -> {
            String distance = MOVE_DISTANCE_UNIT.repeat(car.getPosition());
            System.out.println(car.getName() + CAR_POSITION_SEPARATOR + distance);
        });
        System.out.println();
    }
}
