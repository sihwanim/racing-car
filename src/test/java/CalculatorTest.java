
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 무슨 테스트인지 알려주는 어노테이션
// Junit5에서 추가된 어노테이션
@DisplayName("계산기 테스트")
class CalculatorTest {

	Calculator calc = new Calculator();

	@Test
	@DisplayName("두 수를 더합니다")
	void add() {
		// assertJ에서 제공하는 메서드
		assertThat(calc.add(3, 4)).isEqualTo(7);
	}

	@Test
	@DisplayName("두 수를 뻅니다.")
	void subtract() {
		assertThat(calc.subtract(7, 3)).isEqualTo(4);
	}

	@Test
	@DisplayName("두 수를 곱합니다")
	void multiply() {
		assertThat(calc.multiply(5, 6)).isEqualTo(30);
	}

	@Test
	@DisplayName("두 수를 나눕니다.")
	void divide() {
		assertThat(calc.divide(42, 6)).isEqualTo(7);

		// assertThatThrownBy -> throw로 던져지는 에러 캐치
		assertThatThrownBy(() -> {
			calc.divide(6, 0);
		}).isInstanceOf(ArithmeticException.class);

		/*
		* 테스트 케이스 확인하는 방법
		* 1. Good Case / Bad Case를 나눠서 검사
		* 2. assertAll 사용
		* 	- 모든 테스트 케이스를 검사하는 데 어디서 에러가 나는지 확인 가능하게 함
		*/

		/* assertAll(
		* 	() -> assertThat(cal.divide(42, 6)).isEqualTo(7),
		* 	() -> assertThatThrownBy(() -> {
					calc.divide(6, 0);
				}).isInstanceOf(ArithmeticException.class)
		* );
		* */
	}
}