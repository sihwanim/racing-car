package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Name.CAR_NAME_VALIDATION_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("자동차 이름을 생성한다.")
    public void makeCarName() {
        String name = "ahn";
        assertThat(new Name(name).getName()).isEqualTo(name);

    }

    @Test
    @DisplayName("자동차 이름은 5자 이하여야 한다.")
    public void makeCarWithWrongName() {
        String name = "wrongName";
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_VALIDATION_ERROR_MESSAGE);

    }
}