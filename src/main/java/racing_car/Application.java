package racing_car;

import java.util.Scanner;
import racing_car.controller.GameController;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController(scanner);
        gameController.play();
        scanner.close();
    }
}
