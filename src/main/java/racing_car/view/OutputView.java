package racing_car.view;

import java.util.List;
import racing_car.domain.car.Car;

public class OutputView {
    public static final String CAR_POSITION_SEPARATOR = " : ";
    public static final String RESULT = "실행 결과";
    public static final String MOVE_DISTANCE_UNIT = "-";
    public static final String WINNER_SEPARATOR = ", ";
    public static final String WIN_MESSAGE = "가 최종 우승했습니다.";
    public static final String NO_WINNER_MESSAGE = "우승자는 없습니다.";
    public static final String NAME_CHANGE_MESSAGE = "<<이름 변경>> ";
    public static final String CHANGE_ARROW = " -> ";


    public static void printResultMessage() {
        System.out.println(RESULT);
    }

    public static void printCarPosition(List<Car> cars) {
        cars.forEach(car -> {
            String distance = MOVE_DISTANCE_UNIT.repeat(car.getPosition());
            System.out.println(car.getName() + CAR_POSITION_SEPARATOR + distance);
        });
        System.out.println();
    }

    public static void printWinners(List<String> carNames) {
        if (carNames.size() == 0) {
            System.out.println(NO_WINNER_MESSAGE);
            return;
        }
        System.out.println(String.join(WINNER_SEPARATOR, carNames).concat(WIN_MESSAGE));
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public  static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNameChange(String oldName, String newName) {
        System.out.println(NAME_CHANGE_MESSAGE + oldName + CHANGE_ARROW + newName);
    }
}
