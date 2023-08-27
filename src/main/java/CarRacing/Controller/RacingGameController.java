package CarRacing.Controller;

import CarRacing.Domain.*;
import CarRacing.View.RacingGameInputView;
import CarRacing.View.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    RacingGameOutputView racingGameOutputView = new RacingGameOutputView();

    public void playGame() {
        RacingGame racingGame = new RacingGame();
        String inputName = RacingGameInputView.MessageName();
        Cars cars = RacingGameFactory.inputCars(inputName);
        RacingGameFactory racingGameFactory = new RacingGameFactory();

        int playNum = racingGameFactory.inputPlayNum(
                RacingGameInputView.MessageNumber()
        );

        for (int i = 0; i < playNum; i++) {
            racingGame.moveCars(cars);
            racingGameOutputView.printTrialResult(cars);
        }

        showResult(cars);
    }

    public void showResult(Cars cars) {
        racingGameOutputView.printWinner(cars);
    }

}
