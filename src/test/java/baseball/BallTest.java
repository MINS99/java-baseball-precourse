package baseball;

import baseball.Model.Ball;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void position_정보와_number_정보가_같은_두_Ball_객체는_동일하다(int position, int number) {
        // given & when
        Ball ball1 = new Ball(position, number);
        Ball ball2 = new Ball(position, number);

        // then
        assertThat(ball1).isEqualTo(ball2);
    }
}
