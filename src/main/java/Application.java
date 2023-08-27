import controller.CarController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        CarController gameController = new CarController(scanner);
        gameController.play();
    }
}