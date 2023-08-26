package racing_car.domain.car;

import java.util.Objects;

public class Name {
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    public static final String NAME_CHANGE_MESSAGE = "<<이름 변경>> ";
    public static final String CHANGE_ARROW = " -> ";
    public static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        this.name = limitNameLength(name);
    }
    public String limitNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH)
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
