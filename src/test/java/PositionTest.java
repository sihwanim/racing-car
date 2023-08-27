import domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	@DisplayName("위치 이동 테스트_4이상")
	void movementOver4Test() {
		Car car = new Car("아마네");
		int originPosition = car.getPosition();
		car.goForward(4);
		Assertions.assertEquals(originPosition + 1, car.getPosition());
	}

	@Test
	@DisplayName("위치 이동 테스트_4미만")
	void movementUnder4Test() {
		Car car = new Car("아마네");
		int originPosition = car.getPosition();
		car.goForward(2);
		Assertions.assertEquals(originPosition, car.getPosition());
	}
}
