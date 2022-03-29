package CarRacing.View;

import CarRacing.Domain.Car;
import CarRacing.Domain.RacingGame;
import CarRacing.Utils.RandomUtils;

import java.util.List;
import java.util.Scanner;


public class RacingGameOutputView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_SITUATION_MESSAGE_FORMAT = "%s : %s%n";
    private static final String WINNERS_MESSAGE_FORMAT = "%s가 최종 우승했습니다.%n";
    private static final String LIST_SEPARATOR = ", ";
    private static final String MOVEMENT = "-";
    private static final Scanner sc = new Scanner(System.in);



    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarPositions(final RacingGame racingGame) {
        List<Car> cars = racingGame.getCars();
        cars.forEach(car -> {
            final String progressBar = makeProgressBar(car.getPosition());
            System.out.printf(CAR_SITUATION_MESSAGE_FORMAT, car.getName(), progressBar);
        });
    }

    private static String makeProgressBar(final int length) {
        return MOVEMENT.repeat(length);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(final List<String> winners) {
        System.out.printf(WINNERS_MESSAGE_FORMAT, winners);
    }
}
