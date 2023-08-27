package CarRacing.Domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() <= NAME_LENGTH_MIN && name.length() >= NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(
                    String.format("이름은 %d자 이상 %d자 이하로 적어주세요", NAME_LENGTH_MIN, NAME_LENGTH_MAX));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
