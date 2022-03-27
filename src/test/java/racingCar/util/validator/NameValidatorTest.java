package racingCar.util.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.validator.NameValidator;

public class NameValidatorTest {

	@Test
	@DisplayName("자동차의 이름들 생성 유효성 검사: 중복")
	void 자동차이름_중복검사_Negative(){
		String carNames = "pobi,hong,gil,mark,gil";

		// then
		assertThrows(IllegalArgumentException.class, () -> {
			NameValidator.validateNames(carNames);
		});
	}

	@Test
	@DisplayName("자동차의 이름 생성 유효성 검사: null")
	void 자동차이름_null값_검사_Positive(){
		String carNames = "";

		// then
		assertThrows(IllegalArgumentException.class, () -> {
			NameValidator.validateNames(carNames);
		});

	}

	@Test
	@DisplayName("자동차의 이름 생성 유효성 검사: 2개 이상")
	void 자동차이름_2개_이상_Negative(){
		String carNames = "crong";

		// then
		assertThrows(IllegalArgumentException.class, () -> {
			NameValidator.validateNames(carNames);
		});

	}

	@Test
	@DisplayName("자동차의 이름 생성 유효성 검사: 이름 길이")
	void 자동차이름_길이검사_Negative(){
		String carNames = "spring";

		// then
		assertThrows(IllegalArgumentException.class, () -> {
			NameValidator.validateNames(carNames);
		});

	}

	@DisplayName("자동차 정상 생성")
	@Test
	void 정상입력(){
		assertThatCode(() -> NameValidator.validateName("pobi"))
			.doesNotThrowAnyException();
	}
}
