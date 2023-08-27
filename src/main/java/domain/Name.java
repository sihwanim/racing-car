package domain;

import java.util.Objects;

public class Name {
    public static final String CAR_NAME_VALIDATION_ERROR_MESSAGE = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name.trim());
        this.name = name.trim();
    }

    private void validate(String name) {
        if (!name.isBlank() && name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_VALIDATION_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
