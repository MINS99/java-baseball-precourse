package baseball.Model;

import java.util.Objects;

public class Position {
    private final int position;
    private static final int MIN_INDEX = 1;
    private static final int MAX_INDEX = 3;
    private static final String POSITION_ERROR_MESSAGE = "입력한 값은 세자리 수이어야 합니다.";

    public Position(int position) {
        invalidPositionCheck(position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    private void invalidPositionCheck(int position) {
        if (position < MIN_INDEX || position > MAX_INDEX) {
            throw new IllegalArgumentException(POSITION_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
