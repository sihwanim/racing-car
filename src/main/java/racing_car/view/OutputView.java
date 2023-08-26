package racing_car.view;

import java.util.List;
import racing_car.domain.car.Car;

public class OutputView {

    private static final String RESULT = "실행 결과";
    private static final String CAR_POSITION_SEPARATOR = " : ";
    private static final String MOVE_DISTANCE_UNIT = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String WIN_MESSAGE = "가 최종 우승했습니다.";


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
        StringBuilder sb = new StringBuilder();
        carNames.forEach(name -> sb.append(name).append(WINNER_SEPARATOR));
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(WIN_MESSAGE);
        System.out.println(sb);
    }
}
