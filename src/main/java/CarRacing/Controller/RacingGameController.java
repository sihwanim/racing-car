package CarRacing.Controller;

import CarRacing.Domain.Cars;
import CarRacing.Domain.RacingGame;
import CarRacing.Domain.RacingGameFactory;
import CarRacing.Domain.Trial;
import CarRacing.View.RacingGameInputView;
import CarRacing.View.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    public RacingGameController() {

    }

    public void play() {
        final RacingGame racingGame = prepare();
        race(racingGame);
        finish(racingGame);
    }

    public RacingGame prepare() {
        String input = RacingGameInputView.requestCars();
        Cars cars = RacingGameFactory.generateCars(input);

        input = RacingGameInputView.requestTrial();
        Trial trial = RacingGameFactory.generateTrial(input);

        return new RacingGame(cars, trial);
    }

    private void race(final RacingGame racingGame) {
        RacingGameOutputView.printNewLine();
        RacingGameOutputView.printResult();

        while (!racingGame.isFinished()) {
            racingGame.tryToMove();
            RacingGameOutputView.printCarPositions(racingGame);
            RacingGameOutputView.printNewLine();
        }
    }

    private void finish(final RacingGame racingGame) {
        final List<String> winnerNames = racingGame.findWinners();
        RacingGameOutputView.printWinners(winnerNames);
    }
}
