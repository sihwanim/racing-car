package racingCar.util.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	@DisplayName("이름이 잘못 입력되었을 때를 확인한다.")
	@Test
	void 이름비정상입력(){
		assertThatThrownBy(() -> {
			NameGenerator.generatorCarsName("pobi12,crong,honux");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
