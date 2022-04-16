package baseball;

import baseball.Model.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    @ParameterizedTest
    @CsvSource({"1", "2", "3"})
    void 위치_객체는_1에서_3사이의_수를_가지고있다(int input) {
        // given
        Position position = new Position(input);

        // when
        int output = position.getPosition();

        // then
        Assertions.assertThat(input).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({"0", "4"})
    void 위치_객체는_1에서_3사이의_수가_아니면_오류를_발생시킨다(int input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Position(input)
        );
    }
}
