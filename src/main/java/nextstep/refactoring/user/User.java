package nextstep.refactoring.user;

import java.util.Objects;

public class User {
    public static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public User(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
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
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}