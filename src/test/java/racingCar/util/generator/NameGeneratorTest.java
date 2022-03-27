package racingCar.util.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.generator.NameGenerator;

public class NameGeneratorTest {
	@DisplayName("이름이 제대로 입력되는지 확인한다.")
	@Test
	void 이름정상입력(){
		assertThat(NameGenerator.generatorCarsName("pobi,crong,honux"))
			.contains("pobi", "crong", "honux");
	}
}
