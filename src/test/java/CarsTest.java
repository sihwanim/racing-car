import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName("차 리스트 생성")
	void createCars() {
		String list = "a,b,c";
		Cars cars = new Cars(list);
		Assertions.assertNotNull(cars.getCars());
	}

	@Test
	@DisplayName("중복 이름 차 생성")
	void createDuplicateCar() {
		String list = "a,a,b";
		try {
			new Cars(list);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("이름이 중복된 차량이 있습니다.", e.getMessage());
		}
	}

	@Test
	@DisplayName("차 생성_0대")
	void createMaximumCar() {
		String list = " ";
		try {
			new Cars(list);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("차량이 한대 이상이어야 합니다.", e.getMessage());
		}
	}
}
