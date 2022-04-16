package baseball.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Balls {
    private final List<Ball> balls;
    private static final String REGEX_NUMBER = "[1-9]+";
    private static final String INVALID_INPUT_MESSAGE = "입력하는 값은 3자리의 숫자여야 합니다.";
    private static final String DUP_NUM_MESSAGE = "값은 중복으로 입력할 수 없습니다.";

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls newInstance(String input) {
        invalidNumberCheck(input);
        duplicateNumberCheck(input);
        return new Balls(createBalls(input));
    }

    private static void invalidNumberCheck(String input) {
        if (input == null || input.length() != 3 || !input.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static void duplicateNumberCheck(String input) {
        LinkedHashSet<String> checkSet = new LinkedHashSet<>(Arrays.asList(input.split("")));
        if (checkSet.size() != input.length()) {
            throw new IllegalArgumentException(DUP_NUM_MESSAGE);
        }
    }

    private static List<Ball> createBalls(String input) {
        List<Ball> newBalls = new ArrayList<>();
        for (int index = 1; index <= input.length(); index++) {
            newBalls.add(new Ball(index, input.charAt(index-1) - '0'));
        }
        return newBalls;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
