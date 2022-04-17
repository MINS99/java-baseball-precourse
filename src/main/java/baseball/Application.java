package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.GameInput;
import baseball.view.GameOutput;

public class Application {
    public static void main(String[] args) {
        BaseballGameController gameController = new BaseballGameController(new GameInput(), new GameOutput());
        gameController.startGame();
    }
}
