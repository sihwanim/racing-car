package racing_car.view;

import static racing_car.utils.StringUtil.limitLength;
import static racing_car.utils.StringUtil.removeDuplicates;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_SPLIT_REGEX = " *, *";
    private static final int LIMIT_LENGTH = 5;
    private final Scanner scanner;


    // TODO : 차이름들 입력 예외처리
    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String[] carNames = scanner.nextLine().split(CAR_NAME_SPLIT_REGEX);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = limitLength(carNames[i], LIMIT_LENGTH);
        }
        return removeDuplicates(carNames);
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
