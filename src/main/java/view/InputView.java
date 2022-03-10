package view;

import java.util.Scanner;

public class InputView {
	private final Scanner sc;
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String TRIAL_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	public InputView(Scanner sc){
		this.sc = sc;
	}

	public String getCarNames(){
		System.out.println(CAR_NAME_INPUT_MESSAGE);

		return sc.nextLine();
	}

	public String getTrialNumber() {
		System.out.println(TRIAL_NUMBER_INPUT_MESSAGE);

		return sc.nextLine();
	}

}
