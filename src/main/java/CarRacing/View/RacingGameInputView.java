package CarRacing.View;

import java.util.Scanner;

public class RacingGameInputView {
    private static String GETNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String GETNUMBER_MESSAGE = "몇회 시도하시겠습니까?";
    private static final String LIST_SEPARATOR = ", ";
    private static Scanner sc = new Scanner(System.in);

    public static String MessageName() {
        System.out.println(GETNAME_MESSAGE);
        String result = sc.nextLine();
        return result;
    }

    public static String MessageNumber() {
        System.out.println(GETNUMBER_MESSAGE);
        String result = sc.nextLine();

        return result;
    }


}
