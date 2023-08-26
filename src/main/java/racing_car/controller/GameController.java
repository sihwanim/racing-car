package racing_car.controller;

import static racing_car.view.OutputView.printCarPosition;
import static racing_car.view.OutputView.printError;
import static racing_car.view.OutputView.printResultMessage;
import static racing_car.view.OutputView.printWinners;

import java.util.Scanner;
import racing_car.domain.Round;
import racing_car.domain.car.Cars;
import racing_car.view.InputView;

public class GameController {

    private final InputView inputView;
    private Cars cars;
    private Round round;


    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        makeCars();
        round = makeRound();
        startGame();
        announceWinners();
    }

    public void makeCars() {
        try {
            String[] carNames = inputView.inputCarNames();
            cars = new Cars(carNames);
        } catch (NullPointerException e) {
            printError(e);
            makeCars();
        }
    }

    public Round makeRound() {
        try {
           return new Round(inputView.inputTryCount());
        } catch (IllegalArgumentException e) {
            printError(e);
            return makeRound();
        }
    }

    public void startGame() {
        printResultMessage();
        for (int i = 0; i < round.getCount(); i++) {
            cars.goCars();
            printCarPosition(cars.getCars());
        }
    }

    public void announceWinners() {
        printWinners(cars.findWinners());
    }
}
