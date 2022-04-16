package CarRacing.Domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name.trim();
    }

    public Name(final Name name) {
        this.name = name.getName();
    }

    public static void validate(final String name) {
        if (name.length() > NAME_LENGTH_MAX || name.length() < NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %d 자 이상 %d 자 이하로 입력해주세요.",NAME_LENGTH_MIN,NAME_LENGTH_MAX));
        }
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
