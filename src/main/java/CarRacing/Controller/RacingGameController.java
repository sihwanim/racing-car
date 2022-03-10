package CarRacing.Controller;

import CarRacing.Domain.Cars;
import CarRacing.Domain.RacingGame;
import CarRacing.Domain.RacingGameFactory;
import CarRacing.Domain.Trial;
import CarRacing.View.RacingGameView;

import java.util.List;

public class RacingGameController {
    private RacingGameController(){

    }

    public static void play(){
        final RacingGame racingGame = prepare();
        race(racingGame);
        finish(racingGame);
    }
    public static RacingGame prepare(){
        String input = RacingGameView.requestCars();
        Cars cars = RacingGameFactory.generateCars(input);

        input = RacingGameView.requestTrial();
        Trial trial = RacingGameFactory.generateTrial(input);

        return new RacingGame(cars, trial);
    }

    private static void race(final RacingGame racingGame){
        RacingGameView.printNewLine();
        RacingGameView.printResult();

        while (!racingGame.isFinished()){
            racingGame.tryToMove();
            RacingGameView.printCarPositions(racingGame);
            RacingGameView.printNewLine();
        }
    }

    private static void finish(final RacingGame racingGame){
        final List<String> winnerNames = racingGame.getWinners();
        RacingGameView.printWinners(winnerNames);
    }
}
