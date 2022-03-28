package racingCar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

	Car car1, car2, car3;
	Cars cars;

	@BeforeEach
	void init(){
		car1 = new Car("pobi");
		car2 = new Car("crong");
		car3 = new Car("honux");
		List<Car> carList = Arrays.asList(car1, car2, car3);

		cars = new Cars(carList);
	}

	@Test
	void 우승자_1명(){
		car1.go(true);
		assertThat(cars.findWinners()).contains("pobi");
	}

	@Test
	void 우승자_여러명(){
		car1.go(true);
		car2.go(true);
		car3.go(true);
		assertThat(cars.findWinners()).contains("pobi", "crong", "honux");
	}

}
