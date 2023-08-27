package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputRound() {
        return scanner.nextLine();
    }

    public String[] inputCarNames() {
        String cars = scanner.nextLine();
        return cars.split(",");
    }
}
