package baseball;

import baseball.model.BallStatus;
import baseball.model.Game;
import baseball.model.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game newGame;

    @BeforeEach
    private void beforeEach() {
        newGame = new Game();
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123", "456:456"}, delimiter = ':')
    public void 같은_수가_같은_자리에_있으면_스트라이크(String comInput, String playerInput) {
        // given
        newGame.start(comInput);
        List<BallStatus> ballStatusList = newGame.input(playerInput);

        // when
        int strike = Collections.frequency(ballStatusList, BallStatus.STRIKE);

        // then
        assertThat(strike).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:231", "456:564"}, delimiter = ':')
    public void 같은_수가_다른_자리에_있으면_볼(String comInput, String playerInput) {
        // given
        newGame.start(comInput);
        List<BallStatus> ballStatusList = newGame.input(playerInput);

        // when
        int ball = Collections.frequency(ballStatusList, BallStatus.BALL);

        // then
        assertThat(ball).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:456", "456:789"}, delimiter = ':')
    public void 같은_수가_전혀_없으면_낫싱(String comInput, String playerInput) {
        // given
        newGame.start(comInput);
        List<BallStatus> ballStatusList = newGame.input(playerInput);

        // when
        int strike = Collections.frequency(ballStatusList, BallStatus.STRIKE);
        int ball = Collections.frequency(ballStatusList, BallStatus.BALL);

        // then
        assertThat(strike + ball).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123", "456:456"}, delimiter = ':')
    public void 세개의_수를_모두_맞히면_게임이_종료된다(String comInput, String playerInput) {
        // given
        newGame.start(comInput);

        // when
        newGame.input(playerInput);

        // then
        assertThat(newGame.getGameStatus()).isEqualTo(GameStatus.FINISHED);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123", "456:456"}, delimiter = ':')
    public void 게임종료_후_1을_입력하면_게임을_다시_시작한다(String comInput, String playerInput) {
        // given
        newGame.start(comInput);
        newGame.input(playerInput);

        // when
        newGame.end("1");

        assertThat(newGame.getGameStatus()).isEqualTo(GameStatus.PROGRESS);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123", "456:456"}, delimiter = ':')
    public void 게임종료_후_2를_입력하면_게임을_종료한다(String comInput, String playerInput) {
        // given
        newGame.start(comInput);
        newGame.input(playerInput);

        // when
        newGame.end("2");

        assertThat(newGame.getGameStatus()).isEqualTo(GameStatus.END);
    }
}
