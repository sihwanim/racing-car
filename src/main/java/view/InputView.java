package view;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_CAR_NAMES_MESSAGE = "차량 이름을 입력해주세요";
	private static final String INPUT_TRAIL_NUMBER_MESSAGE = "시도 횟수를 입력해주세요";


	public static String inputCarNames(Scanner scanner) {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);

		return scanner.nextLine();
	}

	public static String inputTrailNumber(Scanner scanner) {
		System.out.println(INPUT_TRAIL_NUMBER_MESSAGE);

		return scanner.nextLine();
	}
}
