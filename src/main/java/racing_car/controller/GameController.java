package racing_car.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import racing_car.domain.car.Car;
import racing_car.domain.car.Cars;
import racing_car.view.InputView;
import racing_car.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;


    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
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
        outputView.printResultMessage();
        for (int t = 1; t <= tryCount; t++) {
            cars.goCars();
            outputView.printCarPosition(cars.getCars());
        }
    }

    public void announceWinners() {
        outputView.printWinners(cars.findWinners());
    }
}
