package racing_car.controller;

import static racing_car.view.OutputView.printCarPosition;
import static racing_car.view.OutputView.printError;
import static racing_car.view.OutputView.printResultMessage;
import static racing_car.view.OutputView.printWinners;

import java.util.Scanner;
import racing_car.domain.Round;
import racing_car.domain.Cars;
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
        makeRound();
        startGame();
        announceWinners();
    }

    public void makeCars() {
        try {
            cars = new Cars(inputView.inputCarNames());
        } catch (NullPointerException e) {
            printError(e);
            makeCars();
        }
    }

    public void makeRound() {
        try {
           round = new Round(inputView.inputTryCount());
        } catch (IllegalArgumentException e) {
            printError(e);
            makeRound();
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
