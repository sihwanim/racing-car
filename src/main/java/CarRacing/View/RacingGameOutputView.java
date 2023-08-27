package CarRacing.View;

import CarRacing.Domain.Car;
import CarRacing.Domain.Cars;
import CarRacing.Domain.RacingGame;


public class RacingGameOutputView {

    private static final String CAR_SITUATION_MESSAGE_FORMAT = "%s : %s%n";
    private static final String WINNERS_MESSAGE_FORMAT = "%s가 최종 우승했습니다.%n";
    private static final String MOVEMENT = "-";
    public RacingGame racingGame = new RacingGame();

    public void printWinner(Cars cars) {
        String winners = racingGame.findWinners(cars);
        System.out.println(String.format(WINNERS_MESSAGE_FORMAT, winners));
    }

    public void printTrialResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format(CAR_SITUATION_MESSAGE_FORMAT, car.getName(), MOVEMENT.repeat(car.getPosition())));
        }
    }

}
