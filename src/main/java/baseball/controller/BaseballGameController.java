package baseball.controller;

import baseball.model.BallStatus;
import baseball.model.Game;
import baseball.model.GameStatus;
import baseball.utils.RandomGenerator;
import baseball.view.GameInput;
import baseball.view.GameOutput;
import java.util.List;

public class BaseballGameController {
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    public BaseballGameController(GameInput gameInput, GameOutput gameOutput) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
    }

    public void startGame() {
        Game game = new Game();
        while (game.getGameStatus() != GameStatus.END) {
            play(game);
        }
    }

    private void play(Game game) {
        game.start(RandomGenerator.create());
        while (game.getGameStatus() != GameStatus.FINISHED) {
            List<BallStatus> ballStatusList = game.input(gameInput.input());
            gameOutput.viewBallStatus(ballStatusList);
        }
        gameOutput.printEndResult();
        game.end(gameInput.restart());
    }
}
