package racingCar.util.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.generator.TrialNumberGenerator;

public class TrialNumberGeneratorTest {
	@DisplayName("경기횟수가 잘 입력되었는지 확인한다.")
	@Test
	void 경기횟수입력(){
		assertThat(TrialNumberGenerator.generateTrialNumber("4"))
			.isEqualTo(4);
	}
}
