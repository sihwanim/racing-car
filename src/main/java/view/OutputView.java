package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String RUNNING_UNIT = "-";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printCars(List<Car> cars) {
        cars.forEach((car -> {
            System.out.println(car.getName() + " : " + RUNNING_UNIT.repeat(car.getPosition()));
        }));
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        final String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public static void printInputRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printError(Exception error) {
        System.out.println(ERROR_PREFIX + error.getMessage());
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }
}
