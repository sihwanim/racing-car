import domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	@DisplayName("생성 테스트")
	void createCarTest() {
		Assertions.assertNotNull(new Car("amane"));
	}

	@Test
	@DisplayName("같은 위치에 대한 테스트")
	void samePositionTest() {
		Assertions.assertTrue(new Car("amane", 5).isSamePosition(5));
	}

	@Test
	@DisplayName("다른 위치에 대한 테스트")
	void differPositionErrorTest() {
		Assertions.assertFalse(new Car("amane", 10).isSamePosition(4));
	}

}
