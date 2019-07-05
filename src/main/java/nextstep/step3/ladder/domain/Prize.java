package nextstep.step3.ladder.domain;

import java.util.Objects;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 22:24
 */
public class Prize {
    private static final String NULL_EMPTY_EXCEPTION_MESSAGE = "결과가 입력이 안되었습니다.";
    private static final String UNDER_WIN_NUMBER = "입력된 결과가 0보다 작습니다.";
    private static final String UNSUITE = "꽝";

    private static final Prize NOT_PRIZE = new Prize(UNSUITE);
    private final String prize;

    private Prize(String prize) {
        this.prize = prize;
    }

    public static Prize of(String prize) {
        if (prize == null || prize.isEmpty()) {
            throw new IllegalArgumentException(NULL_EMPTY_EXCEPTION_MESSAGE);
        }

        if (UNSUITE.equals(prize)) {
            return NOT_PRIZE;
        }
        return new Prize(prize);
    }

    public static Prize of(int prize) {
        if (prize < 0) {
            throw new IllegalArgumentException(UNDER_WIN_NUMBER);
        }
        return new Prize(String.valueOf(prize));
    }

    public String getPrize() {
        return this.prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return prize.equals(prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}