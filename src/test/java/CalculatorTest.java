
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 테스트")
class CalculatorTest {

    private final Calculator cal = new Calculator();

    @Test
    @DisplayName("계산기에서 두 숫자를 더한다.")
    void add() {
        assertThat(cal.add(3, 4)).isEqualTo(7);
    }

    @Test
    @DisplayName("계산기에서 두 숫자를 뺀다.")
    void subtract() {
        assertThat(cal.subtract(3, 4)).isEqualTo(-1);
    }

    @Test
    @DisplayName("계산기에서 두 숫자를 곱한다.")
    void multiply() {
        assertThat(cal.multiply(3, 4)).isEqualTo(12);
    }

    @Test
    @DisplayName("계산기에서 두 숫자를 나눈다.")
    void divide() {
        assertAll(
            () -> assertThat(cal.divide(6, 2)).isEqualTo(3),
            () -> assertThatThrownBy(() -> {
                cal.divide(6, 0);
            }).isInstanceOf(IllegalArgumentException.class)
        );
    }
}