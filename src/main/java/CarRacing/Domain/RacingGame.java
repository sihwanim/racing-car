package CarRacing.Domain;

import CarRacing.Utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    RandomUtils randomUtils = new RandomUtils();
    private final int GO_STOP_NUM = 4;

    public Cars moveCars(Cars cars){
       for(int i = 0 ; i < cars.cars.size(); i++){
           moveCar(cars.cars.get(i));
       }
       return cars;
    }

    private Car moveCar(Car car){
        int num = randomUtils.goRandomNumber();
        if(num >= GO_STOP_NUM)
            car.position = new Position(car.position.getPosition() + 1);

        return car;
    }

    public int findMaxPosition(Cars cars){

        return cars.cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public String findWinners(Cars cars) {
        int maxPosition = findMaxPosition(cars);

        return cars.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));


    }
}
