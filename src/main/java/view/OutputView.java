package view;

import java.util.List;

public class OutputView {
	private static final String POSITION_SIGN = "-";
	private static final String SPLIT_POINT = ",";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";

	public static void printResult(String name, int position){
		System.out.print(name + " : ");

		for (int i = 0; i < position; i++) {
			System.out.print(POSITION_SIGN);
		}
		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		System.out.print(WINNER_MESSAGE);
		System.out.println(String.join(SPLIT_POINT, winners));
	}
}
