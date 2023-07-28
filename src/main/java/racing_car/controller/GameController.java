package racing_car.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import racing_car.domain.car.Car;
import racing_car.domain.car.Cars;
import racing_car.view.InputView;

public class GameController {
    private final InputView inputView;

    
    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        String[] carNames = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();
        Cars cars = new Cars(Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList())
        );

        // 경기
        // - 1. 1회의 시도마다 자동차들 전진 or 멈춤
        // - 2. 실행 결과 출력
        // - 3. 시도 횟수만큼 반복
        // 우승자 발표
    }
}
