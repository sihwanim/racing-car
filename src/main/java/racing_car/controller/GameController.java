package racing_car.controller;

import static racing_car.view.OutputView.printCarPosition;
import static racing_car.view.OutputView.printResultMessage;
import static racing_car.view.OutputView.printWinners;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import racing_car.domain.car.Car;
import racing_car.domain.car.Cars;
import racing_car.view.InputView;

public class GameController {

    private final InputView inputView;
    private Cars cars;


    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        String[] carNames = inputView.inputCarNames();
        cars = new Cars(Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList())
        );
        int tryCount = inputView.inputTryCount();
        startGame(tryCount);
        announceWinners();
    }

    public void startGame(int tryCount) {
        printResultMessage();
        for (int t = 1; t <= tryCount; t++) {
            cars.goCars();
            printCarPosition(cars.getCars());
        }
    }

    public void announceWinners() {
        printWinners(cars.findWinners());
    }
}
