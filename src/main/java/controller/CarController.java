package controller;

import domain.Cars;
import domain.Game;
import domain.Round;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class CarController {
    private final InputView inputView;

    public CarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void play() {
        try {
            final Cars cars = makeCars();
            final Round round = makeRound();
            final Game game = new Game(cars, round);

            OutputView.printResult();
            while (!game.isEnd()) {
                game.race();
                OutputView.printCars(cars.getCars());
            }
            OutputView.printWinners(game.findWinners());
        } catch (Exception error) {
            OutputView.printError(error);
        }
    }

    private Round makeRound() {
        try {
            OutputView.printInputRoundMessage();
            return new Round(inputView.inputRound());
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            return makeRound();
        }
    }

    private Cars makeCars() {
        try {
            OutputView.printInputCarNameMessage();
            return new Cars(inputView.inputCarNames());
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
            return makeCars();
        }
    }
}
