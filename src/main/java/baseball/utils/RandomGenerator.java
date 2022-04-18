package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class RandomGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String DELIMITER_VALUE = "";

    public static String create() {
        LinkedHashSet<String> inputValue = new LinkedHashSet<>();
        while (inputValue.size() != 3) {
            inputValue.add(String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
        }

        return String.join(DELIMITER_VALUE, inputValue);
    }
}
