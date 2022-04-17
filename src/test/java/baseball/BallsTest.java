package baseball;

import baseball.model.Ball;
import baseball.model.Balls;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallsTest {
    @ParameterizedTest
    @CsvSource({"246", "135", "597", "589"})
    void Balls_객체는_3개의_숫자를_가지고있다(String input) {
        // given
        Balls balls = Balls.newInstance(input);

        // when
        List<Ball> ballList = balls.getBalls();

        // then
        assertThat(ballList.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource({"2467", "1358", "5973", "5891"})
    void Balls_객체는_3자리_수가_아니면_오류를_발생시킨다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Balls.newInstance(input)
        );
    }

    @ParameterizedTest
    @CsvSource({"a12", "ab2", "abc", "1bc", "1%^"})
    void Balls_객체는_숫자가_아닌_수가_있으면_오류를_발생시킨다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Balls.newInstance(input)
        );
    }

    @ParameterizedTest
    @CsvSource({"012", "102", "120"})
    void Balls_객체는_숫자_중_0이_있으면_오류를_발생시킨다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Balls.newInstance(input)
        );
    }

    @ParameterizedTest
    @CsvSource({"112", "122", "111", "131"})
    void Balls_객체는_숫자에_중복이_있으면_오류를_발생시킨다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Balls.newInstance(input)
        );
    }

    @Test
    void Balls_객체는_공백이_입력되면_오류를_발생시킨다() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Balls.newInstance("")
        );
    }

    @Test
    void Balls_객체는_null이_입력되면_오류를_발생시킨다() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Balls.newInstance(null)
        );
    }
}
