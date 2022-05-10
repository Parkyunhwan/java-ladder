package nextstep.ladder.view;

import static java.lang.System.out;
import static nextstep.ladder.domain.Name.MAXIMUM_NAME_LENGTH;
import static nextstep.ladder.domain.Name.MINIMUM_NAME_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.utils.StringUtils;

public class LadderGameInputCui {

    private static final int MAXIMUM_TRY_COUNT = 3;
    public static final int MINIMUM_LADDER_HEIGHT = 2;
    public static final int MAXIMUM_LADDER_HEIGHT = 100;

    private Scanner scanner = new Scanner(System.in);

    public List<String> inputParticipants() {
        return inputParticipantsImpl(MAXIMUM_TRY_COUNT);
    }

    private List<String> inputParticipantsImpl(int tryCount) {
        if (tryCount <= 0) System.exit(1);

        out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) / 남은 시도 횟수: %d\n", tryCount);
        String inputLine = scanner.nextLine();

        List<String> names = Arrays.stream(inputLine.split(","))
            .map(String::trim)
            .collect(Collectors.toUnmodifiableList());

        if (!isValidNames(names)) {
            return inputParticipantsImpl(tryCount-1);
        }

        return names;
    }

    private boolean isValidNames(List<String> names) {
        return names.stream()
            .noneMatch(name ->
                StringUtils.isEmpty(name)
                || name.length() < MINIMUM_NAME_LENGTH
                || name.length() > MAXIMUM_NAME_LENGTH
            );
    }

    public int inputMaxLadderHeight() {
        return inputMaxLadderHeightImpl(MAXIMUM_TRY_COUNT);
    }

    private int inputMaxLadderHeightImpl(int tryCount) {
        out.printf("최대 사다리 높이는 몇 개인가요? (최소 2, 최대 100) / 남은 시도 횟수: %d\n", tryCount);
        int maxLadderHeight = scanner.nextInt();
        scanner.nextLine();

        if (isValid(maxLadderHeight)) {
            return inputMaxLadderHeightImpl(tryCount-1);
        }

        return maxLadderHeight;
    }

    private boolean isValid(int maxLadderHeight) {
        return maxLadderHeight < MINIMUM_LADDER_HEIGHT
            || maxLadderHeight > MAXIMUM_LADDER_HEIGHT;
    }

}