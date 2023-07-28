package racing_car.view;

import static racing_car.utils.StringUtil.limitFiveOrLessLength;
import static racing_car.utils.StringUtil.removeDuplicates;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;


    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(" *, *");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = limitFiveOrLessLength(carNames[i]);
        }
        return removeDuplicates(carNames);
    }
}
