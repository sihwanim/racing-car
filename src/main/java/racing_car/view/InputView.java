package racing_car.view;

import static racing_car.utils.StringUtil.limitLength;
import static racing_car.utils.StringUtil.removeDuplicates;

import java.util.Scanner;

public class InputView {
    private final int LIMIT_LENGTH = 5;
    private final Scanner scanner;


    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(" *, *");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = limitLength(carNames[i], LIMIT_LENGTH);
        }
        return removeDuplicates(carNames);
    }

    public int inputTryCount() {
        int count;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            count = scanner.nextInt();
            scanner.nextLine();
        } while (count <= 0);
        return count;
    }
}