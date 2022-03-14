package view;

import java.util.List;
import model.Car;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "가 우승하였습니다.";

	public static void printCarPosition(List<Car> cars){
		for(Car c : cars){
			System.out.print(c.getName() + ": ");
			printDistance(c);
			System.out.println();
		}
		System.out.println();
	}

	public static void printDistance(Car c){
		for (int i = 0; i < c.getPosition(); i++){
			System.out.print("-");
		}
	}

	public static void printMessage(){
		System.out.println(RESULT_MESSAGE);
	}

	public static void printWinner(List<String> winners){
		System.out.print(winners.get(0));
		for(int i = 1; i < winners.size(); i++){
			System.out.print(", " + winners.get(i));
		}
		System.out.println(WINNER_MESSAGE);
	}
}
