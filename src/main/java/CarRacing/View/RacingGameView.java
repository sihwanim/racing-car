package CarRacing.View;

import CarRacing.Domain.Car;
import CarRacing.Domain.RacingGame;
import CarRacing.Utils.RandomUtils;

import java.util.List;
import java.util.Scanner;


public class RacingGameView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_MESSAGE = "몇회 시도하시겠습니까?";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_SITUATION_MESSAGE_FORMAT = "%s : %s%n";
    private static final String WINNERS_MESSAGE_FORMAT = "%s가 최종 우승했습니다.%n";
    private static final String LIST_SEPARATOR = ", ";
    private static final String MOVEMENT = "-";
    private static final Scanner sc = new Scanner(System.in);

    public static String requestCars(){
        System.out.println(START_MESSAGE);
        String result = sc.nextLine();
        return result;
    }

    public static String requestTrial(){
        System.out.println(TRIAL_MESSAGE);
        String result = sc.nextLine();
        return result;
    }

    public static void printResult(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarPositions(final RacingGame racingGame){
        List<Car> cars = racingGame.getCars();
//        for(Car car:cars){
//            final String progressBar = makeProgressBar(car.getPosition());
//            System.out.printf(CAR_SITUATION_MESSAGE_FORMAT, car.getName(),progressBar);
//        }
        cars.forEach(car -> {
            final String progressBar = makeProgressBar(car.getPosition());
            System.out.printf(CAR_SITUATION_MESSAGE_FORMAT, car.getName(),progressBar);
        });
    }

    private static String makeProgressBar(final int length){
        return MOVEMENT.repeat(length);
    }

    public static void printNewLine(){
        System.out.println();
    }

    public static void printWinners(final List<String> winners){
        final String winnerNames = String.join(LIST_SEPARATOR, winners);
        System.out.printf(WINNERS_MESSAGE_FORMAT, winners);
    }
}
