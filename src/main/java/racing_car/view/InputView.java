package racing_car.view;

import java.util.Scanner;

public class InputView {
    public static final String CAR_NAMES_COUNT_ERROR_MESSAGE = "[ERROR] 자동차는 최소 1대 이상 입력해야합니다.";
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_SPLIT_REGEX = " *, *";
    private static final int LIMIT_LENGTH = 5;
    private final Scanner scanner;


    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String[] carNames = scanner.nextLine().split(CAR_NAME_SPLIT_REGEX);
        if (carNames.length == 0) {
            throw new NullPointerException(CAR_NAMES_COUNT_ERROR_MESSAGE);
        }
        return carNames;
    }

    // TODO : 시도횟수 입력 예외처리
    public int inputTryCount() {
        int count;
        do {
            System.out.println(TRY_COUNT_INPUT_MESSAGE);
            count = scanner.nextInt();
            scanner.nextLine();
        } while (count <= 0);
        return count;
    }
}
