package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RoundTest {

    @Test
    @DisplayName("라운드를 생성한다.")
    void create() {
        Round round = new Round("5");
        assertThat(round.getRound()).isEqualTo(5);
    }

    @Test
    @DisplayName("라운드는 자연수이어야 한다.")
    void wrongInput() {
        assertThatThrownBy(() -> new Round("not integer"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이싱 횟수는 자연수이어야 합니다.");
    }

    @Test
    @DisplayName("라운드는 0보다 커야 한다.")
    void wrongNumber() {
        assertThatThrownBy(() -> new Round("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이싱 횟수는 0보다 커야합니다.");
    }

    @Test
    @DisplayName("한 라운드가 끝나면 라운드 횟수가 차감된다.")
    void over() {
        Round round = new Round("10");
        round.over();
        assertThat(round.getRound()).isEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource({"3,false", "1,true"})
    @DisplayName("모든 라운드가 끝났는지 여부를 알 수 있다.")
    void isEnd(String number, boolean isEnd) {
        Round round = new Round(number);
        round.over();
        assertThat(round.isEnd()).isEqualTo(isEnd);
    }
}