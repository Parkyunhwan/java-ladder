package nextstep.ladder;

import java.util.Objects;

public class GameResult {
    private final User user;
    private final int resultPosition;

    public GameResult(User user, int resultPosition) {
        this.user = user;
        this.resultPosition = resultPosition;
    }

    public boolean isSameUser(User user) {
        return this.user.equals(user);
    }

    public User getUser() {
        return user;
    }

    public int getResultPosition() {
        return resultPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return resultPosition == that.resultPosition && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, resultPosition);
    }
}
