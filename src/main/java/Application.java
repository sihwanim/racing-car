import controller.Controller;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Controller controller = new Controller(new Scanner(System.in));
		controller.run();
	}
}
