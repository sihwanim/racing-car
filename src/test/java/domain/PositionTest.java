package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {

    @Test
    @DisplayName("자동차 위치을 생성한다.")
    public void makeCarName() {
        int position = 10;
        assertThat(new Position(position).getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("자동차 위치는 한 칸씩 나아갈 수 있다.")
    void moveForward() {
        int start = 0;
        Position position = new Position(start);
        position.moveForward();
        assertThat(position.getPosition()).isEqualTo(start + 1);
    }
}