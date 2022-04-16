package baseball;

import baseball.Model.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void 숫자_객체는_1에서_9사이의_수를_가지고있다(int input) {
        // given
        Number number = new Number(input);

        // when
        int output = number.getNumber();

        // then
        assertThat(input).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({"0", "10"})
    void 숫자_객체는_1에서_9사이의_수가_아니면_오류를_발생시킨다(int input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Number(input)
        );
    }
}
