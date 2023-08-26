package racing_car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing_car.domain.Round.ROUND_COUNT_ERROR_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {


    @DisplayName("양의 정수로 라운드를 생성한다.")
    @Test
    void createCountWithPositiveInt() {
        Round round = new Round("6");
        assertThat(round.getCount()).isEqualTo(6);
    }

    @DisplayName("문자로 라운드를 생성한다.")
    @Test
    void createCountWithString() {
         assertThatThrownBy(() -> new Round("a"))
             .isInstanceOf(IllegalArgumentException.class)
             .hasMessage(ROUND_COUNT_ERROR_MESSAGE);
    }


    @DisplayName("음수로 라운드를 생성한다.")
    @Test
    void createCountWithNegativeInt() {
        assertThatThrownBy(() -> new Round("-3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_COUNT_ERROR_MESSAGE);
    }
}