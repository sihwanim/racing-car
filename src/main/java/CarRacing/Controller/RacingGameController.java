package CarRacing.Controller;

import CarRacing.Domain.*;
import CarRacing.View.RacingGameInputView;
import CarRacing.View.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    RacingGameOutputView racingGameOutputView = new RacingGameOutputView();

    public void play() {
        RacingGame racingGame = new RacingGame();
        String inputName = RacingGameInputView.MessageName();
        Cars cars = RacingGameFactory.inputCars(inputName);
        int inputNum = RacingGameInputView.MessageNumber();

        for (int i = 0; i < inputNum; i++) {
            racingGame.moveCars(cars);
            racingGameOutputView.printTrialResult(cars);
            System.out.println();
        }

        showResult(cars);
    }

    public void showResult(Cars cars) {
        racingGameOutputView.printWinner(cars);
    }

}
