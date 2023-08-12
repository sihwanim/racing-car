import domain.Car;
import domain.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

	@Test
	@DisplayName("이름 생성 테스트")
	void createNameTest() {
		Assertions.assertEquals(new Car("amane").getName(), new Name("amane"));
	}

	@Test
	@DisplayName("이름 생성 에러 테스트")
	void createNameLengthErrorTest() {
		String errorName = "name_length_over_5";
		try {
			new Car(errorName);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(errorName + "은(는) 이름 길이 범위에 맞지 않습니다.", e.getMessage());
		}
	}




}
