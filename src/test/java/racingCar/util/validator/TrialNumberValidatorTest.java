package racingCar.util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.validator.NameValidator;
import util.validator.TrailNumberValidator;

public class TrialNumberValidatorTest {
	@Test
	@DisplayName("경기 횟수 생성 유효성 검사: 음수")
	void 경기횟수_음수_Negative(){

		// then
		assertThrows(IllegalArgumentException.class, () -> {
			TrailNumberValidator.validate("-1");
		});
	}

	@Test
	@DisplayName("경기 횟수 생성 유효성 검사: 정수인지 아닌지 검사")
	void 경기횟수_정수_Negative(){

		// then
		assertThrows(IllegalArgumentException.class, () -> {
			TrailNumberValidator.validate("10000번");
		});
	}

	@DisplayName("경기횟수 정상 생성")
	@Test
	void 정상입력(){
		assertThatCode(() -> TrailNumberValidator.validate("4"))
			.doesNotThrowAnyException();
	}
}
