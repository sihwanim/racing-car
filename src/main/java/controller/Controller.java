package controller;

import domain.Car;
import domain.Cars;
import domain.TrialNumber;
import java.util.List;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Controller {
	private final Scanner scanner;

	public Controller(Scanner scanner) {
		this.scanner = scanner;
	}

	public void run() {
		final Cars cars = new Cars(InputView.inputCarNames(scanner));
		final TrialNumber trialNumber = new TrialNumber(InputView.inputTrailNumber(scanner));

		showPositions(cars.getCars());

		for (int i = 0; i < trialNumber.getTrialNumber(); i++) {
			cars.goForwardRandomly();
			showPositions(cars.getCars());
		}

		showWinners(cars.getWinners());
	}

	private void showPositions(List<Car> cars) {
		cars.forEach(
			car -> OutputView.printResult(
				car.getName(), car.getPosition()
			)
		);

		System.out.println();
	}

	private void showWinners(List<String> winners) {
		OutputView.printWinners(winners);
	}
}
