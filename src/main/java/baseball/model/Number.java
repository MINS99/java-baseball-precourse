package baseball.model;

import java.util.Objects;

public class Number {
    private final int number;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String NUMBER_ERROR_MESSAGE = "1이상 9이하의 숫자만 입력가능합니다.";

    public Number(int number) {
        invalidNumberCheck(number);
        this.number = number;
    }

    private void invalidNumberCheck(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
