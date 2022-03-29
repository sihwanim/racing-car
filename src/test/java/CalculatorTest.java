import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;


@DisplayName("계산기 테스트")
class CalculatorTest {

    Calculator cal = new Calculator();

    @Test
    @DisplayName("계산기에서 덧셈")
    void add() {
        assertThat(cal.add(3, 4)).isEqualTo(7);
    }

    @Test
    @DisplayName("계산기에서 뺄셈")
    void subtract() {
        assertThat(cal.subtract(5, 3)).isEqualTo(2);
    }

    @Test
    @DisplayName("계산기에서 곱셈")
    void multiply() {
        assertThat(cal.multiply(5, 6)).isEqualTo(30);
    }

    @Test
    @DisplayName("계산기에서 나눗셈")
    void divide() {
        assertAll(
                () -> assertThat(cal.divide(6, 2)).isEqualTo(3),
                () -> assertThatThrownBy(() -> {
                    cal.divide(6, 0);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }
}