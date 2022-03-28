package racingCar.model;


import static org.assertj.core.api.Assertions.assertThatCode;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@DisplayName("자동차 정상 생성")
	@Test
	void 정상입력(){
		assertThatCode(() -> new Car("pobi"))
			.doesNotThrowAnyException();
	}
}
