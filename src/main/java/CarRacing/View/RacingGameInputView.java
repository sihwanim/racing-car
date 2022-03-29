package CarRacing.View;

import java.util.Scanner;

public class RacingGameInputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_MESSAGE = "몇회 시도하시겠습니까?";
    private static final String LIST_SEPARATOR = ", ";
    private static final Scanner sc = new Scanner(System.in);

    public static String requestCars() {
        System.out.println(START_MESSAGE);
        String result = sc.nextLine();
        return result;
    }

    public static String requestTrial() {
        System.out.println(TRIAL_MESSAGE);
        String result = sc.nextLine();
        return result;
    }
}
